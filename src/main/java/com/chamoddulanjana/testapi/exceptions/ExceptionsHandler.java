package com.chamoddulanjana.testapi.exceptions;

import com.chamoddulanjana.testapi.dto.response.ResponseInfo;
import com.chamoddulanjana.testapi.exceptions.customExceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseInfo> handleException (NotFoundException exception){
        return new ResponseEntity<>(
              ResponseInfo.builder()
                      .status(HttpStatus.NOT_FOUND)
                      .message(exception.getMessage())
                      .timestamp(LocalDateTime.now())
                      .build(), HttpStatus.NOT_FOUND
        );
    }
}

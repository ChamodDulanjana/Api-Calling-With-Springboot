package com.chamoddulanjana.testapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseInfo {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

}

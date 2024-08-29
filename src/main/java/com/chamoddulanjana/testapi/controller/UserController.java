package com.chamoddulanjana.testapi.controller;

import com.chamoddulanjana.testapi.dto.UserDto;
import com.chamoddulanjana.testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(@RequestHeader("Authorization") String token) {
        return userService.getUsers(token);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return userService.getUserById(id, token);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto, @RequestHeader("Authorization") String token) {
        userService.saveUser(userDto, token);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto,
                              @RequestParam String id,
                              @RequestHeader("Authorization") String token) {
        return userService.updateUser(userDto, id, token);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id, @RequestHeader("Authorization") String token) {
        userService.deleteUser(id, token);
    }
}

package com.chamoddulanjana.testapi.service;

import com.chamoddulanjana.testapi.dto.UserDto;

import java.util.List;

public interface UserService {
    String getUsers(String token);
    UserDto getUserById(String id, String token);
    UserDto saveUser(UserDto userDto, String token);
    UserDto updateUser(UserDto userDto, String id, String token);
    boolean deleteUser(String id, String token);
}

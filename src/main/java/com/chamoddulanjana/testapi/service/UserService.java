package com.chamoddulanjana.testapi.service;

import com.chamoddulanjana.testapi.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers(String token);
    UserDto getUserById(String id, String token);
    void saveUser(UserDto userDto, String token);
    UserDto updateUser(UserDto userDto, String id, String token);
    void deleteUser(String id, String token);
}

package com.chamoddulanjana.testapi.service;

import com.chamoddulanjana.testapi.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(String id);
    void saveUser(UserDto userDto);
    void updateUser(UserDto userDto, String id);
    void deleteUser(String id);
}

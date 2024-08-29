package com.chamoddulanjana.testapi.service.impl;

import com.chamoddulanjana.testapi.dto.UserDto;
import com.chamoddulanjana.testapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDto> getUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public void saveUser(UserDto userDto) {

    }

    @Override
    public void updateUser(UserDto userDto, String id) {

    }

    @Override
    public void deleteUser(String id) {

    }
}

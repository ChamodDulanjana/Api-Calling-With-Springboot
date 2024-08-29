package com.chamoddulanjana.testapi.service.impl;

import com.chamoddulanjana.testapi.dto.UserDto;
import com.chamoddulanjana.testapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Override
    public List<UserDto> getUsers(String token) {
        return null;
    }

    @Override
    public UserDto getUserById(String id, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id,
                HttpMethod.GET,
                entity,
                UserDto.class
        );
        return response.getBody();
    }

    @Override
    public void saveUser(UserDto userDto, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<UserDto> entity = new HttpEntity<>(userDto, headers);

            ResponseEntity<UserDto> response = restTemplate.exchange(
                    "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users",
                    HttpMethod.POST,
                    entity,
                    UserDto.class);

        System.out.println(response.getBody());
    }

    @Override
    public UserDto updateUser(UserDto userDto, String id, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<UserDto> entity = new HttpEntity<>(userDto, headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id,
                HttpMethod.PUT,
                entity,
                UserDto.class
        );
        return response.getBody();
    }

    @Override
    public void deleteUser(String id, String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id+"/trash",
                HttpMethod.POST,
                entity,
                UserDto.class
        );

        System.out.println(response.getBody());
    }
}

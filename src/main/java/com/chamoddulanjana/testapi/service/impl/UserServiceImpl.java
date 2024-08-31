package com.chamoddulanjana.testapi.service.impl;

import com.chamoddulanjana.testapi.dto.UserDto;
import com.chamoddulanjana.testapi.service.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final OkHttpClient okHttpClient;
    private final Gson gson;

    @Override
    public String getUsers(String token) {
        Request request = new Request.Builder()
                .url("https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users")
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    @Override
    public UserDto getUserById(String id, String token) {
        // Handle Request Using Rest Template
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id,
                HttpMethod.GET,
                entity,
                UserDto.class
        );
        return response.getBody();*/

        // Handle Request using OKHttp Client

        Request request = new Request.Builder()
                .url("https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            }
            return gson.fromJson(response.body().string(), UserDto.class);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto, String token) {

        // Handle Request Using Rest Template
        /*HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<UserDto> entity = new HttpEntity<>(userDto, headers);

            ResponseEntity<UserDto> response = restTemplate.exchange(
                    "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users",
                    HttpMethod.POST,
                    entity,
                    UserDto.class);

        System.out.println(response.getBody());*/

        // Handle Request using OKHttp Client

        String json = gson.toJson(userDto);

        RequestBody requestBody = RequestBody.create(json, okhttp3.MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url("https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users")
                .addHeader("Authorization" , "Bearer " + token )
                .addHeader("Content-Type" , "application/json")
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            }
            return gson.fromJson(response.body().string(), UserDto.class);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        } finally {
            if (response != null) {
                response.body().close();
            }
        }


    }

    @Override
    public UserDto updateUser(UserDto userDto, String id, String token) {

        // Handle Request Using Rest Template
        /*HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<UserDto> entity = new HttpEntity<>(userDto, headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id,
                HttpMethod.PUT,
                entity,
                UserDto.class
        );
        return response.getBody();*/

        // Handle Request using OKHttp Client

        String json = gson.toJson(userDto);

        RequestBody requestBody = RequestBody.create(json, okhttp3.MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url("https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .patch(requestBody)
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            }
            return gson.fromJson(response.body().string(), UserDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    @Override
    public boolean deleteUser(String id, String token) {

        // Handle Request Using Rest Template
        /*HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDto> response = restTemplate.exchange(
                "https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/"+id+"/trash",
                HttpMethod.POST,
                entity,
                UserDto.class
        );

        System.out.println(response.getBody());*/

        // Handle Request using OKHttp Client

        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.get("application/json"), "{}");

        Request request = new Request.Builder()
                .url("https://57a015cc2c334f16b1088fd4615c3572.weavy.io/api/users/" +id+ "/trash")
                .addHeader("Authorization", "Bearer "+ token)
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
            }
            return response.isSuccessful();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.body().close();
            }
        }

    }
}

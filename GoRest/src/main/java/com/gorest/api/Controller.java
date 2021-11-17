package com.gorest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gorest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RequestMapping("/public/v1")
@RestController
public class Controller {

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/users/{id}")
    public String getUserById(@PathVariable("id") String id) throws JsonProcessingException {
        return restTemplate.getForObject("https://gorest.co.in/public/v1/users/{id}", String.class);
    }

    @PostMapping("users/")
    public User createUser(@RequestBody User user){
        User newUser = restTemplate.postForObject("https://gorest.co.in/public/v1/users", user, User.class);
        return user;
    }
}

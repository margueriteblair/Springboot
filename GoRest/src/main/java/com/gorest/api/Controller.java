package com.gorest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gorest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/public/v1")
@RestController
public class Controller {

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/users/{id}")
    public String getUserById(@PathVariable("id") String id) throws JsonProcessingException {
        String url = "https://gorest.co.in/public/v1/users/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                id
        );
        System.out.println(response.getBody());
        return response.getBody();
    }

    @PostMapping(value = "users/", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User user){
        User newUser = restTemplate.postForObject("https://gorest.co.in/public/v1/users", user, User.class);
        return newUser;
    }
}

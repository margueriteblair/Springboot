package com.gorest.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gorest.model.GoRestResponse;
import com.gorest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RequestMapping("/public/v1")
@RestController
public class Controller {

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/test")
    public String testPostRoute() {
        return "yes posty";
    }

    @GetMapping("/allUsers")
    public GoRestResponse allUsers(RestTemplate restTemplate) {
        return restTemplate.getForObject("https://gorest.co.in/public/v1/users", GoRestResponse.class);
    }

    @GetMapping("getUser/{id}")
    public Object getUser(RestTemplate restTemplate, @PathVariable("id") String id) {
        String URL = "https://gorest.co.in/public/v1/users"+id;
        return restTemplate.getForObject(URL, GoRestResponse.class).getData();
    }

//    @GetMapping(value = "/users/{id}")
//    public String getUserById(@PathVariable("id") String id) throws JsonProcessingException {
//        String url = "https://gorest.co.in/public/v1/users/{id}";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        HttpEntity request = new HttpEntity(headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                request,
//                String.class,
//                id
//        );
//        System.out.println(response.getBody());
//        return response.getBody();
//    }

    @PostMapping(value = "users/", consumes = "application/json")
    public User createUser(@RequestBody User user){
        User newUser = restTemplate.postForObject("https://gorest.co.in/public/v1/users", user, User.class);
        return newUser;
    }

    //need putmapping for updating
    //need
}

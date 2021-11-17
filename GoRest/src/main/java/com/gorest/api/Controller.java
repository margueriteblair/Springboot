package com.gorest.api;

import com.gorest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/https://goest.co.in/public/v1/")
@RestController
public class Controller {

    @Autowired
    Environment env;

    @GetMapping(value = "/users/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "Hey, test worked for " + id;
    }

    @PostMapping("users/")
    public User createUser(@RequestBody User user){
        if (user == null) {
            throw new IllegalArgumentException("User must not be null & have all required fields")
        } else {
            return user;
        }
    }
}

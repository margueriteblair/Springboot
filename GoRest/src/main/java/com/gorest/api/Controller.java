package com.gorest.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/https://goest.co.in/public/v1/")
@RestController
public class Controller {

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable("id") String id) {
//        return https://gorest.co.in/public/v1/users/{id}
    }

    @PostMapping(path = "users/")
    public User createUser(@RequestBody User user){
        if (user == null) {
            throw new ServerException();
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }
}

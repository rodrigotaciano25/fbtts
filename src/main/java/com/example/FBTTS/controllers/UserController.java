package com.example.FBTTS.controllers;

import com.example.FBTTS.repositories.UserRepository;
import com.example.FBTTS.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

}

package com.niru.controller;

import com.niru.model.Users;
import com.niru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userServiceservice;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
      return   userServiceservice.saveRegister(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userServiceservice.verify(user);
    }
}

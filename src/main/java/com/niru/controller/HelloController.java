package com.niru.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/greet")
public class HelloController {

    @GetMapping("/")
    public String getGreet(HttpServletRequest request) {

        return "Hello World: " + request.getSession().getId();
    }
}

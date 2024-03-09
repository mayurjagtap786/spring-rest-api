package com.example.restwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/greet/{name}")
    private String greetUser(@PathVariable String name){

        return String.format("Hello %s",name);

    }
}

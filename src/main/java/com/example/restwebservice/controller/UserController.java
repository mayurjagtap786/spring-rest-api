package com.example.restwebservice.controller;

import java.net.URI;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restwebservice.beans.User;
import com.example.restwebservice.exceptions.UserNotFoundException;
import com.example.restwebservice.serviceImpl.UserServiceImpl;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public User greetUser(@PathVariable int id){
        return  userService.getUser(id).orElseThrow( () -> new UserNotFoundException("User Not found"));
    }

    @GetMapping("/")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("request Body {}",user);
       User savedUser =  userService.saveUser(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getUserID())
                        .toUri();
         return ResponseEntity.created(location).build();
    }
}
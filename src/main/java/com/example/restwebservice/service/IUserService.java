package com.example.restwebservice.service;

import com.example.restwebservice.beans.User;
import com.example.restwebservice.entity.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    public Optional<User> getUser(int id);

    public List<User> getAllUser();

    public User saveUser(User user);

}

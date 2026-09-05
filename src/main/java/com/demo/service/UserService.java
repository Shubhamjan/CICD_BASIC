package com.demo.service;


import com.demo.entity.User;
//import com.demo.repository.UserRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private List<User> users = new ArrayList<>();

    public User addUser(User user) {

//        return userRepository.save(user);
        userRepository.save(new User(user.getId(),user.getName(), user.getEmail()));
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
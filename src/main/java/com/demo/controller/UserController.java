package com.demo.controller;


import com.demo.entity.User;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        log.info("The request received for adding the user");
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping
    public List<User> getUsers() {
        log.info("The all users successfully");
        return userService.getAllUsers();
    }
}
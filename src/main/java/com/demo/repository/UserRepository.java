package com.demo.repository;

import com.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = null;

    @PostConstruct
    public void init () {
        userList = new ArrayList<>();
    }

    public User save(User user) {
        userList.add(user);
        return user;
    }

    public List<User> findAll() {
        return userList;
    }
}

package com.demo.repository;

import com.demo.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserRepository {

    List<User> userList = null;

    @PostConstruct
    public void init () {
        log.info("List initialized");
        userList = new ArrayList<>();
    }

    public User save(User user) {
        userList.add(user);
        log.info("Save the user");
        return user;
    }

    public List<User> findAll() {
        log.info("Retrieving the users");
        return userList;
    }
}

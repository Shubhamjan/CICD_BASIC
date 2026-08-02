package com.demo.controller;


import com.demo.entity.User;
import com.demo.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    void setup() {

        user = new User();

        user.setId(1L);
        user.setName("Shubham");
        user.setEmail("shubham@gmail.com");
    }

    @Test
    void shouldSaveUser() {

        when(userService.addUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.addUser(user);

        assertEquals(200, response.getStatusCode().value());

        assertNotNull(response.getBody());

        assertEquals("Shubham", response.getBody().getName());

        verify(userService, times(1)).addUser(user);
    }
}
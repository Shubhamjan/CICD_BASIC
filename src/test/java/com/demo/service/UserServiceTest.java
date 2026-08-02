package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
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
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setup() {
        user = new User();
        user.setId(1L);
        user.setName("Shubham");
        user.setEmail("shubham@gmail.com");
    }

    @Test
    void shouldSaveUser(){
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.addUser(user);
        assertNotNull(savedUser);
        assertEquals(1L, savedUser.getId());
        assertEquals("Shubham", savedUser.getName());
        assertEquals("shubham@gmail.com", savedUser.getEmail());

        verify(userRepository, times(1)).save(user);
    }

}

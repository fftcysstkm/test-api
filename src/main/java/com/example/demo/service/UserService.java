package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
    
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private final UserMapper userMapper;
    
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }
}
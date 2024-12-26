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

    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }

    public void createUser(User user) {
        // なぜかh2のauto incrementが動かなかったので
        var newId = userMapper.getMaxId() + 1;
        var newUser = user.copyWithId(newId);
        userMapper.insertUser(newUser);
    }
}

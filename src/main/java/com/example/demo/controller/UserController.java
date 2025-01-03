package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "ユーザー", description = "ユーザー関連のAPI")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "ユーザー一覧取得", description = "ユーザー一覧を取得します")
    @GetMapping("/list")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "ユーザー新規登録", description = "新しいユーザーを登録します")
    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "ユーザー更新", description = "指定されたIDのユーザー情報を更新します")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody User request) {
        userService.updateUserById(request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "ユーザー削除", description = "指定されたIDのユーザーを削除します")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}

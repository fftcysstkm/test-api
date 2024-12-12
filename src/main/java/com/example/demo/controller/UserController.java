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

    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @Operation(summary = "テスト用API", description = "動作確認用のhelloを返します")
    @GetMapping("/test")
    public String hello(){
        return "hello";
    }

    @Operation(summary = "ユーザー一覧取得", description = "ユーザー一覧を取得します")
    @GetMapping("/list")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "ユーザー更新", description = "指定されたIDのユーザー情報を更新します")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody User request) {
        userService.updateUserById(request);
        return ResponseEntity.noContent().build();
    }

}

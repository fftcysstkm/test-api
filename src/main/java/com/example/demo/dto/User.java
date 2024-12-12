package com.example.demo.dto;

import org.springframework.lang.NonNull;

public record User(
    @NonNull
    Long id,
    @NonNull
    String name,
    @NonNull
    String phone,
    @NonNull
    String email
) {}

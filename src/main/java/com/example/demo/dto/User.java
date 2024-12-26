package com.example.demo.dto;

import org.springframework.lang.NonNull;

public record User(
    Long id,
    @NonNull
    String name,
    @NonNull
    String phone,
    @NonNull
    String email
) {
    /**
     * IDだけ入力し、ほかは引き継いだUser生成
     * @param id
     * @return IDのみ更新したUser
     */
    public User copyWithId(@NonNull Long id){
        return new User(id, this.name, this.phone, this.email);
    }
}

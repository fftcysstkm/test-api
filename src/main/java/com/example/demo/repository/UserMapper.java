package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getUsers();

    @Select("UPDATE users SET name = #{name}, phone = #{phone}, email = #{email} WHERE id = #{id}")
    void updateUserById(User user);

    @Select("DELETE FROM users WHERE id = #{id}")
    void deleteUserById(Long id);

    @Insert("INSERT INTO users (id, name, phone, email) VALUES (#{id}, #{name}, #{phone}, #{email})")
    void insertUser(User newUser);

    @Select("SELECT MAX(id) FROM users")
    Long getMaxId();
}
package com.example.dao;

import com.example.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    //根据id查询用户
    User getUserById(String id);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(String id);
}

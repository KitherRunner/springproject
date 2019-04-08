package com.kither.service;

import com.kither.bean.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User find(Integer id);

    void insert(User user);

    void update(User user);

    User findOne(int index);
}

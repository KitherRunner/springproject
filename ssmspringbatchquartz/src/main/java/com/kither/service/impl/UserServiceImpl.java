package com.kither.service.impl;

import com.kither.bean.User;
import com.kither.mapper.UserMapper;
import com.kither.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}

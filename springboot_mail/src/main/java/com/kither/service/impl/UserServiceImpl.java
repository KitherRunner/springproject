package com.kither.service.impl;

import com.kither.mapper.UserMapper;
import com.kither.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int activeUser(Integer id) {
        return userMapper.avtiveUser(id);
    }
}

package com.kingdee.service.impl;

import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerivce {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "#id" + "_user")
    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }
}

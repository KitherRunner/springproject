package com.kingdee.service.impl;

import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


}

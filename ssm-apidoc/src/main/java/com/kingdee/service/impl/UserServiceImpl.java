package com.kingdee.service.impl;

import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    @Override
    public User update(User user) {
        userMapper.Update(user);
        return userMapper.find(user.getId());
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id) > 0;
    }

    @Override
    public User add(User user) {
        userMapper.add(user);
        return userMapper.find(user.getId());
    }
}

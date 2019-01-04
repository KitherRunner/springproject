package com.kingdee.service.impl;

import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
// 指定cacheManager
@CacheConfig(cacheManager = "userCacheManager")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "users")
    public User find(Integer id) {
        return userMapper.find(id);
    }
}


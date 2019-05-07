package com.kingdee.service.impl;

import com.google.gson.Gson;
import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
// 指定cacheManager
@CacheConfig(cacheManager = "userCacheManager")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    Gson gson = new Gson();

    @Override
//    @Cacheable(cacheNames = "users")
    public User find(Integer id) {
        // 不使用注解来获取对应的值时，需要自己手动去获取并做相应的更新
        String s = stringRedisTemplate.opsForValue().get("user::" + id);
        User user = null;
        if (s == null) {
            user = userMapper.find(id);
            stringRedisTemplate.opsForValue().set("user::" + id, gson.toJson(user));
        } else {
            user = gson.fromJson(s, User.class);
        }
        return user;
    }
}


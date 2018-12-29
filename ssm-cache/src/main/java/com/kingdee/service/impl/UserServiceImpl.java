package com.kingdee.service.impl;

import com.kingdee.bean.User;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询方法需要开启缓存
     *
     * @param id
     * @return
     */
    // 先从缓存中读取数据，有则不执行方法
    /*
     *  必须指定名称属性，不然报错(不知道去哪个缓存中找)
     *  java.lang.IllegalStateException: No cache could be resolved for 'Builder[public com.kingdee.bean.User com.kingdee.service.impl.UserServiceImpl.update(com.kingdee.bean.User)]
     *  caches=[] | key='' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='' | unless=''' using resolver 'org.springframework.cache.interceptor.SimpleCacheResolver@842b220'.
     *  At least one cache should be provided per cache operation.
     */
    // 设置缓存名称为 users
    @Cacheable("users")
    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    /**
     * 新增用户开启缓存，每次新增用户时刷新缓存
     *
     * @param user
     * @return
     */
    // 每次必定执行方法并刷新缓存
    @CachePut
    @Override
    public User add(User user) {
        userMapper.add(user);
        return userMapper.find(user.getId());
    }

    /**
     * 删除用户时开启缓存
     *
     * @param id
     */
    //  清空缓存
    @CacheEvict
    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    /**
     * 更新用户时刷新对应缓存中的用户信息
     *
     * @param user
     * @return
     */
    // 每次必定执行方法并刷新缓存
    @CachePut("users")
    @Override
    public User update(User user) {
        userMapper.update(user);
        return userMapper.find(user.getId());
    }
}

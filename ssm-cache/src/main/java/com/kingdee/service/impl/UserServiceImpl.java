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
    @Cacheable(value = "users", key = "#id")
    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    /**
     * 新增用户开启缓存，每次新增用户时更新缓存
     *
     * @param user
     * @return
     */
    // 每次必定执行方法并更新缓存(更新指定key的缓存)
    // @CachePut(value = "users", key = "#user.id") // 从参数中取值作为key
    @CachePut(value = "users", key = "#result.id") // 从返回值中取值作为key(@Cacheable：不可以从返回值中取值作为key，因为在方法执行前执行)
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
    //  删除对应缓存
    @CacheEvict(value = "user", key = "#id")
    // @CacheEvict(value = "users", allEntries = true) // 表示删除所有缓存
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

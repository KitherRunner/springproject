package com.kingdee.service;

import com.kingdee.bean.User;

import java.util.List;

public interface UserService {
    User find(Integer id);

    List<User> findAll();
}

package com.kingdee.service;

import com.kingdee.bean.User;

public interface UserService {
    void add(User user);

    User find(Integer id);
}

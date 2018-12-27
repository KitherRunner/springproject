package com.kingdee.service;

import com.kingdee.bean.User;

public interface UserService {

    User find(Integer id);

    User add(User user);

    int delete(Integer id);

    User update(User user);
}

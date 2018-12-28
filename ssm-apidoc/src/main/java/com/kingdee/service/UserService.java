package com.kingdee.service;

import com.kingdee.bean.User;

public interface UserService {

    User find(Integer id);

    User update(User user);

    boolean delete(Integer id);
}

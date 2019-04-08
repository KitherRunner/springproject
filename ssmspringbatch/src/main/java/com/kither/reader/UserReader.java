package com.kither.reader;

import com.kither.bean.User;
import com.kither.service.UserService;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

public class UserReader implements ItemReader<User> {

    private int index = 1;

    @Autowired
    private UserService userService;

    @Override
    public User read() throws Exception {
        return userService.findOne(index++);
    }
}

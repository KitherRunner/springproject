package com.kither.writer;

import com.kither.bean.User;
import com.kither.service.UserService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserWriter implements ItemWriter<User> {

    @Autowired
    private UserService userService;

    @Override
    public void write(List<? extends User> list) throws Exception {
        for (User user : list) {
            userService.update(user);
        }
    }
}

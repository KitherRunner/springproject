package com.kither.listener;

import com.kither.bean.User;
import org.springframework.batch.core.ItemProcessListener;

public class UserProcessorListener implements ItemProcessListener<User, User> {

    @Override
    public void beforeProcess(User user) {
        System.out.println("processor user之前" + " users: " + user);
    }

    @Override
    public void afterProcess(User user, User user2) {
        System.out.println("processor user之后 " + " user1: " + user + " users: " + user2);
    }

    @Override
    public void onProcessError(User user, Exception e) {
        System.out.println("processor user发送异常 " + " e: " + e.getMessage() + " user: " + user);
    }
}

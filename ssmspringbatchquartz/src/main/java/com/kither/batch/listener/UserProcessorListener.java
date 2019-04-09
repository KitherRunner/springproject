package com.kither.batch.listener;

import com.google.gson.Gson;
import com.kither.bean.User;
import org.springframework.batch.core.ItemProcessListener;

public class UserProcessorListener implements ItemProcessListener<User, User> {

    private Gson gson = new Gson();

    @Override
    public void beforeProcess(User user) {
        System.out.println("processor之前 " + " user: " + gson.toJson(user));
    }

    @Override
    public void afterProcess(User user, User user2) {
        System.out.println("processor之后 " + " user1: " + gson.toJson(user) + " user2: " + gson.toJson(user2));
    }

    @Override
    public void onProcessError(User user, Exception e) {
        System.out.println("processor异常: " + " 异常： " + e.getMessage() + " user: " + gson.toJson(user));
    }
}

package com.kither.batch.listener;

import com.google.gson.Gson;
import com.kither.bean.User;
import org.springframework.batch.core.ItemReadListener;

public class UserReaderListener implements ItemReadListener<User> {

    private Gson gson = new Gson();

    @Override
    public void beforeRead() {
        System.out.println("reader之前");
    }

    @Override
    public void afterRead(User user) {
        System.out.println("reader之后 " + " user: " + gson.toJson(user));
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("reader异常: " + e.getMessage());
    }
}

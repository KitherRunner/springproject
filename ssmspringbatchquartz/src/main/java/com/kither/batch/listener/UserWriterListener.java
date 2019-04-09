package com.kither.batch.listener;

import com.google.gson.Gson;
import com.kither.bean.User;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class UserWriterListener implements ItemWriteListener<User> {

    private Gson gson = new Gson();

    @Override
    public void beforeWrite(List<? extends User> list) {
        System.out.println("writer之前 " + " user：" + gson.toJson(list));
    }

    @Override
    public void afterWrite(List<? extends User> list) {
        System.out.println("writer之后 " + " user: " + gson.toJson(list));
    }

    @Override
    public void onWriteError(Exception e, List<? extends User> list) {
        System.out.println("writer异常: " + e.getMessage() + " user: " + gson.toJson(list));
    }
}

package com.kither.listener;

import com.google.gson.Gson;
import com.kither.bean.User;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class UserWriterListener implements ItemWriteListener<User> {

    Gson gson = new Gson();

    @Override
    public void beforeWrite(List<? extends User> list) {
        System.out.println("write user之前 " + " users：" + gson.toJson(list));
    }

    @Override
    public void afterWrite(List<? extends User> list) {
        System.out.println("write user之后" + " users: " + gson.toJson(list));
    }

    @Override
    public void onWriteError(Exception e, List<? extends User> list) {
        System.out.println("write user发送异常" + "e： " + e.getMessage() + " users:" + gson.toJson(list));
    }
}

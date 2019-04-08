package com.kither.listener;

import com.kither.bean.User;
import org.springframework.batch.core.ItemReadListener;

public class UserReaderListener implements ItemReadListener<User> {

    @Override
    public void beforeRead() {
        System.out.println("read user之前");
    }

    @Override
    public void afterRead(User user) {
        System.out.println("read user之后" + user);
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("read user发送异常" + e.getMessage());
    }
}

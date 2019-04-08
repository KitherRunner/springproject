package com.kither.processor;

import com.kither.bean.User;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class UserProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) throws Exception {
        if (0 == user.getGender()) {
            user.setSalary(user.getSalary().multiply(new BigDecimal(2.5)));
            user.setInfo(user.getInfo() + "--processor mail");
        } else {
            user.setSalary(user.getSalary().multiply(new BigDecimal(1.0)));
            user.setInfo(user.getInfo() + "--processor femail");
        }
        return user;
    }
}

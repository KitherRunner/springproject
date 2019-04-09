package com.kither.batch;

import com.kither.bean.User;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) throws Exception {
        BigDecimal rate = null;
        if (user.getGender() == 1) {
            rate = new BigDecimal(2.5);
        } else {
            rate = new BigDecimal(1.5);
        }
        user.setSalary(user.getSalary().multiply(rate));
        user.setInfo(user.getName() + " - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return user;
    }
}

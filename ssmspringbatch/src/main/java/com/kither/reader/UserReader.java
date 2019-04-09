package com.kither.reader;

import com.google.gson.Gson;
import com.kither.bean.User;
import com.kither.service.UserService;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserReader implements ItemReader<User>, InitializingBean {

    private int index = 0;

    private List<User> users;

    // 设置参数，保证每次job运行都有一个唯一的参数使得job不为同一个job，这样springbatch就可以重复运行
    private Date date;

    @Autowired
    private UserService userService;

    // InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，在初始化bean的时候都会执行该方法
    @Override
    public void afterPropertiesSet() throws Exception {
        users = userService.findAll();
        System.out.println("index: " + index);
        System.out.println(new Gson().toJson(users));
    }

    @Override
    public User read() throws Exception {
        User user = null;
        if (users != null && users.size() > 0) {
            if(index < users.size()) {
                user = users.get(index++);
            }
        }
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

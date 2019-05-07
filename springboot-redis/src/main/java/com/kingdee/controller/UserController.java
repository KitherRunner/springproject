package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public User find(@PathVariable("id") Integer id) {
        System.out.println("id: " + id);
        return userService.find(id);

    }
}

package com.kither.controller;

import com.kither.bean.User;
import com.kither.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@MapperScan("com.kither.mapper")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return userService.find(id);
    }

    @PostMapping("add")
    public User add(User user) {
        userService.insert(user);
        return userService.find(user.getId());
    }
}

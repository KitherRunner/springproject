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

    @PostMapping(value = "add", consumes = "application/json")
    // 传递过来的参数是json字符串的时候，必须要使用@RequestBody注解，否则无法映射成对象
    public User add(@RequestBody User user) {
        userService.insert(user);
        return userService.find(user.getId());
    }
}

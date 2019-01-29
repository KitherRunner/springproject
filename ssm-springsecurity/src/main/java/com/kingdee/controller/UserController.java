package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "{id}")
    @ResponseBody
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/customer")
    public String customer() {
        return "customer";
    }
}

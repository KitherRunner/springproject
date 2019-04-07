package com.kither.controller;

import com.kither.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/active")
    private String toTemplate() {
        return "mailTemplate";
    }

    @GetMapping("user/active/{id}")
    @ResponseBody
    public String activeUser(@PathVariable Integer id) {
        return "" + userService.activeUser(id);
    }
}

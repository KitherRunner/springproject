package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@MapperScan("com.kingdee.mapper")
@Api(value = "用户操作控制器")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/user/{id}", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "find", notes = "根据id查询用户", httpMethod = "GET")
    @ResponseBody
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }
}

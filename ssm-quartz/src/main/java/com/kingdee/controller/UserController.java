package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
@Api(value = "UserController", tags = "user", protocols = "http")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    @ApiOperation(value = "find", notes = "根据ID查询用户信息", tags = "user", httpMethod = "GET", response = User.class, produces = "application/json;charset=utf-8")
    @ApiImplicitParam(value = "用户编号", name = "id", required = true, dataType = "int", defaultValue = "1", paramType = "path")
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    @PostMapping("")
    @ResponseBody
    @ApiOperation(value = "add", notes = "新增用户", tags = "user", httpMethod = "POST", response = User.class, produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户编号", name = "id", required = false, defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "用户名称", name = "name", required = true, defaultValue = "张三", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "用户性别", name = "gender", required = false, defaultValue = "male", dataType = "string", paramType = "query")
    })
    public User add(User user) {
        userService.add(user);
        return userService.find(user.getId());
    }
}
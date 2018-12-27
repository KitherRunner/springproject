package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "find", notes = "通过编号获取用户", httpMethod = "GET", response = User.class)
    @ApiImplicitParam(name = "id", value = "编号", dataType = "int", paramType = "path")
    public User find(@PathVariable("id") @NotNull Integer id) {
        return userService.find(id);
    }

    @PostMapping(value = "", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "add", notes = "添加用户并返回添加的用户", httpMethod = "POST", response = User.class)
    public User add(User user) {
        return userService.add(user);
    }

    @DeleteMapping(value = "", produces = "text/html")
    @ApiOperation(value = "delete", notes = "通过编号删除用户", httpMethod = "DELETE", response = Void.class)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.delete(id) > 0;
    }

    @PutMapping(value = "", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "update", notes = "更新用户", httpMethod = "PUT", response = User.class)
    public User update(User user) {
        return userService.update(user);
    }
}

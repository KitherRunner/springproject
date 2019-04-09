package com.kither.controller;

import com.kither.bean.User;
import com.kither.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan("com.kither.mapper")
@Api(value = "用户Controller", tags = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    @ApiOperation(value = "findAll", notes = "查询所有用户", tags = "user", httpMethod = "GET")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "find", notes = "根据ID查询用户", tags = "user", httpMethod = "GET")
    @ApiImplicitParam(value = "用户ID", name = "id", required = true, dataType = "int", paramType = "path")
    public User find(@PathVariable Integer id) {
        return userService.find(id);
    }

    @PutMapping("update")
    @ApiOperation(value = "update", notes = "更新用户", tags = "user", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名称", name = "name", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "用户说明", name = "info", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "用户工资", name = "salary", dataType = "bigdecimal", paramType = "query")
    })
    public void update(User user) {
        userService.update(user);
    }
}

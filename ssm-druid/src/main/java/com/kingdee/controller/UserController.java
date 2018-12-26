package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
@Api(value = "UserController", description = "访问用户的controller")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "hello", produces = "text/html;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "hello", notes = "测试hello访问", response = String.class, httpMethod = "GET")
    public String hello() {
        return "helloworld";
    }


    @GetMapping(value = "{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "find", notes = "根据id查询用户", response = User.class, httpMethod = "GET")
    // 注意注解的每个属性与swagger-ui界面的对应
    @ApiImplicitParam(value = "编号", name = "id", required = true, dataType = "int", paramType = "path", defaultValue = "1")
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }
}

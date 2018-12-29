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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@MapperScan("com.kingdee.mapper")
@Api(value = "用户操作控制器")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * @api {get} /user/:id  根据id查询用户信息
     * @apiName find
     * @apiGroup User
     *
     * @apiSampleRequest http://localhost:8080/user/:id
     *
     * @apiSuccessExample {
     * "id":1,
     * "name":"张三",
     * "password":"张三",
     * "gender":1
     * }
     */
    @GetMapping(value = "/user/{id}", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "find", notes = "根据id查询用户", httpMethod = "GET")
    @ResponseBody
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    /**
     * @api {POST} /user 添加用户
     *
     * @apiName add
     *
     * @apiGroup User
     *
     * @apiParam {String} user.name 姓名
     * @apiParam {String} user.password 密码
     * @apiParam {Integer} [user.gender=0] 性别(0男1女)
     *
     *
     * @apiSampleRequest http://localhost:8080/add
     *
     * @apiSuccessExample
     *      {
     *          "id":"1",
     *          "name":"张三",
     *          "password":"zs123",
     *          "gender":1
     *      }
     *
     * @param user
     * @return
     */
    @PostMapping(value = "user", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "add", notes = "添加用户", response = User.class, httpMethod = "POST")
    @ResponseBody
    public User add(User user) {
        return userService.add(user);
    }
}

package com.kingdee.controller;

import com.kingdee.bean.User;
import com.kingdee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @apiDefine userInfo  用户详细信息
 *
 * @apiSuccess {Integer} id 用户编号
 * @apiSuccess {String} name 用户编号
 * @apiSuccess {String} password 用户密码
 * @apiSuccess {Integer} gender 用户性别
 */

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
     * @apiSampleRequest /user/:id
     *
     * @apiUse userInfo
     * @apiSuccessExample   user
     *  {
     *      "id":1,
     *      "name":"张三",
     *      "password":"张三",
     *      "gender":1
     *  }
     */
    @GetMapping(value = "/user/{id}", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "find", notes = "根据id查询用户", httpMethod = "GET")
    @ResponseBody
    @CrossOrigin    // 解决测试时报错：跨域错误
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
     * @apiParam {String} name 姓名
     * @apiParam {String} password 密码
     * @apiParam {Integer} [gender=0] 性别(0男1女)
     *
     * @apiUse userInfo
     * @apiSampleRequest /user
     *
     *
     * @apiSuccessExample  user
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
    @CrossOrigin    // 解决测试时报错：跨域错误
    public User add(User user) {
        return userService.add(user);
    }
}

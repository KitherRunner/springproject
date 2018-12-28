package com.kingdee.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;

@Controller
@MapperScan("com.kingdee.mapper")
public class UserController {
}

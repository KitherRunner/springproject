package com.kingdee.ssmTest;

import com.kingdee.controller.UserController;
import com.kingdee.mapper.UserMapper;
import com.kingdee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application*.xml")
/* 不配做这个web环境会报错：java.lang.NoClassDefFoundError: javax/servlet/ServletContext */
@WebAppConfiguration
public class ComponentTest {

    @Autowired
    private UserController controller;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testComponent() {
        System.out.println(controller);

        System.out.println(userMapper);

        System.out.println(userService.find(1));
    }
}



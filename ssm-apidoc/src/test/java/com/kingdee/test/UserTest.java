package com.kingdee.test;


import com.kingdee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFind() {
        System.out.println(userService.find(1));
    }
}

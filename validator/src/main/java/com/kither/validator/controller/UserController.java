package com.kither.validator.controller;

import com.kither.validator.domain.User;
import com.kither.validator.validation.ValidationUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private ValidationUtil validationUtil;

    /**
     * 在指定了 produces 时，需要指定(/包含)对应的Accept接收，否则报错 org.springframework.web.HttpMediaTypeNotAcceptableException: Could not find acceptable representation
     */
    @GetMapping(value = "index", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object index() {
        User user = new User();
        user.setBirthday(LocalDateTime.now().plusDays(10));
        Map<String, Object> data = new HashMap<>(4);
        data.put("code", 200);
        data.put("data", validationUtil.validate(user));
        return data;

    }
}

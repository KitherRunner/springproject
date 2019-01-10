package com.kingdee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootstrapController {

    @GetMapping(value = "remote", produces = "application/json;charset=UTF-8")
    public String remote() {
        return "remote";
    }

    @GetMapping(value = "index", produces = "application/json;charset=UTF-8")
    public String index() {
        return "index";
    }
}

package com.kither.controller;

import com.kither.bean.QuartzBaseBean;
import com.kither.service.QuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "QuartzController", tags = "quartz", protocols = "HTTP", description = "自动任务Controller")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    @GetMapping(value = "quartzs", produces = "application/json;chasrset=utf-8")
    @ResponseBody
    @ApiOperation(value = "findAll", notes = "查询所有自动任务", tags = "quartz", httpMethod = "GET")
    public List<QuartzBaseBean> findAll() {
        return quartzService.findAll();
    }
}

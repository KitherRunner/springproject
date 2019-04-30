package com.kither.controller;

import com.kither.bean.LogInfo;
import com.kither.service.LogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "LogInfoController", tags = "loginfo", protocols = "HTTP", description = "日志记录Controller")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    @GetMapping(value = "logs", produces = "application/json;chasrset=utf-8")
    @ResponseBody
    @ApiOperation(value = "findAll", notes = "查询所有日志记录", tags = "loginfo", httpMethod = "GET")
    public List<LogInfo> findAll() {
        return logInfoService.findAll();
    }
}

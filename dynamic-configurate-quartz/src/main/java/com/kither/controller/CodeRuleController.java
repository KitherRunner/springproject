package com.kither.controller;

import com.kither.bean.CodeRule;
import com.kither.service.CodeRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "CodeRuleController", tags = "coderule", protocols = "HTTP", description = "编码规则Controller")
public class CodeRuleController {

    @Autowired
    private CodeRuleService codeRuleService;

    @GetMapping(value = "rules", produces = "application/json;chasrset=utf-8")
    @ResponseBody
    @ApiOperation(value = "findAll", notes = "查询所有编码规则", tags = "coderule", httpMethod = "GET")
    public List<CodeRule> findAll() {
        return codeRuleService.findAll();
    }
}

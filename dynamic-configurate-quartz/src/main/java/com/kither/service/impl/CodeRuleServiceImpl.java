package com.kither.service.impl;

import com.kither.bean.CodeRule;
import com.kither.mapper.CodeRuleMapper;
import com.kither.service.CodeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeRuleServiceImpl implements CodeRuleService {

    @Autowired
    private CodeRuleMapper codeRuleMapper;

    @Override
    public void add(CodeRule codeRule) {
        codeRuleMapper.add(codeRule);
    }

    @Override
    public List<CodeRule> findAll() {
        return codeRuleMapper.findAll();
    }

    @Override
    public String createNext(String billType) {
        return codeRuleMapper.createNext(billType).get("codeRule");
    }
}

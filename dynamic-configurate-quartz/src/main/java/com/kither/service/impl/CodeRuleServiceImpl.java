package com.kither.service.impl;

import com.kither.bean.CodeRule;
import com.kither.mapper.CodeRuleMapper;
import com.kither.service.CodeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, String> map = new HashMap<>();
        map.put("billType", billType);
        codeRuleMapper.createNext(map);
        String number = map.get("codeRule");
        return StringUtils.isEmpty(number) ? null : number;
    }
}

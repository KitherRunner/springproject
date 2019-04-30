package com.kither.service;

import com.kither.bean.CodeRule;

import java.util.List;

public interface CodeRuleService {

    void add(CodeRule codeRule);

    List<CodeRule> findAll();

    String createNext(String billType);
}

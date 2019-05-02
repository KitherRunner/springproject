package com.kither.mapper;

import com.kither.bean.CodeRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CodeRuleMapper {

    void add(CodeRule codeRule);

    List<CodeRule> findAll();

    void createNext(Map<String, String> map);
}

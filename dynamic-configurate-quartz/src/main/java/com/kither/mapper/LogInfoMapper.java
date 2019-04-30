package com.kither.mapper;

import com.kither.bean.LogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogInfoMapper {

    void add(LogInfo info);

    List<LogInfo> findAll();
}

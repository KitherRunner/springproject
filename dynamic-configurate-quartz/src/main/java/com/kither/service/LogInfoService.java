package com.kither.service;

import com.kither.bean.LogInfo;

import java.util.List;

public interface LogInfoService {

    void add(LogInfo info);

    List<LogInfo> findAll();
}

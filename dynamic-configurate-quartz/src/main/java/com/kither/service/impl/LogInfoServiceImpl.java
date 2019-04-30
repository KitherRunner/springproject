package com.kither.service.impl;

import com.kither.bean.LogInfo;
import com.kither.mapper.LogInfoMapper;
import com.kither.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public void add(LogInfo info) {
        logInfoMapper.add(info);
    }

    @Override
    public List<LogInfo> findAll() {
        return logInfoMapper.findAll();
    }
}

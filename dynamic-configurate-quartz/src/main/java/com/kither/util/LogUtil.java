package com.kither.util;

import com.kither.bean.LogInfo;
import com.kither.service.LogInfoService;

import java.io.Serializable;
import java.util.Date;

public class LogUtil implements Serializable {

    public LogUtil(LogInfoService logInfoService) {
        this.logInfoService = logInfoService;
    }

    private LogInfoService logInfoService;

    public void log(String number, String name, String desc, String operate, String operator, Integer state) {

        LogInfo logInfo = new LogInfo();
        logInfo.setNumber(number);
        logInfo.setDesc(desc);
        logInfo.setOperate(operate);
        logInfo.setOperateDate(new Date());
        logInfo.setOperator(operator);
        if (state != -1) {
            logInfo.setState(state);
        }
        logInfo.setName(name);
        logInfoService.add(logInfo);
    }
}

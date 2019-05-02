package com.kither.service.impl;

import com.kither.bean.QuartzBaseBean;
import com.kither.mapper.QuartzMapper;
import com.kither.service.CodeRuleService;
import com.kither.service.LogInfoService;
import com.kither.service.QuartzService;
import com.kither.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private QuartzMapper quartzMapper;

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    private CodeRuleService codeRuleService;

    private static final String BILLTYPE = "RZ";

    @Override
    public void add(QuartzBaseBean bean) {
        quartzMapper.add(bean);
    }

    @Override
    public QuartzBaseBean find(Integer id) {
        return quartzMapper.find(id);
    }

    @Override
    public List<QuartzBaseBean> findAll() {
        return quartzMapper.findAll();
    }

    @Override
    public int enable(Integer id) {
        LogUtil util = new LogUtil(logInfoService);
        int enable = quartzMapper.enable(id);
        String number = codeRuleService.createNext(BILLTYPE);
        number = StringUtils.isEmpty(number) ? null : number;
        if (enable == 1) {
            util.log(number, "启用自动任务", "启动自动任务[" + id + "]", "启用", "kither", 1);
        } else {
            util.log(number, "启用自动任务", "启动自动任务[" + id + "]", "启用", "kither", 0);
        }
        return enable;
    }

    @Override
    public int disabled(Integer id) {
        LogUtil util = new LogUtil(logInfoService);
        int disabled = quartzMapper.disabled(id);
        String number = codeRuleService.createNext(BILLTYPE);
        number = StringUtils.isEmpty(number) ? null : number;
        if (disabled == 1) {
            util.log(number, "禁用自动任务", "禁用自动任务[" + id + "]", "禁用", "kither", 1);
        } else {
            util.log(number, "禁用自动任务", "禁用自动任务[" + id + "]", "禁用", "kither", 0);
        }
        return disabled;
    }
}

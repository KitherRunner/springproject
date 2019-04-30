package com.kither.service.impl;

import com.kither.bean.QuartzBaseBean;
import com.kither.mapper.QuartzMapper;
import com.kither.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private QuartzMapper quartzMapper;

    @Override
    public void add(QuartzBaseBean bean) {
        quartzMapper.add(bean);
    }

    @Override
    public List<QuartzBaseBean> findAll() {
        return quartzMapper.findAll();
    }

    @Override
    public int enable(Integer id) {
        return quartzMapper.enable(id);
    }

    @Override
    public int disabled(Integer id) {
        return quartzMapper.disabled(id);
    }
}

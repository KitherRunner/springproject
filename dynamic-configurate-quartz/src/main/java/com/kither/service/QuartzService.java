package com.kither.service;

import com.kither.bean.QuartzBaseBean;

import java.util.List;

public interface QuartzService {

    void add(QuartzBaseBean info);

    List<QuartzBaseBean> findAll();

    int enable(Integer id);

    int disabled(Integer id);
}

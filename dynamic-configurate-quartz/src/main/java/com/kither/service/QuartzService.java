package com.kither.service;

import com.kither.bean.QuartzBaseBean;

import java.util.List;

public interface QuartzService {

    void add(QuartzBaseBean info);

    QuartzBaseBean find(Integer id);

    List<QuartzBaseBean> findAll();

    int enable(Integer id);

    int disabled(Integer id);
}

package com.kither.mapper;

import com.kither.bean.QuartzBaseBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuartzMapper {

    void add(QuartzBaseBean info);

    QuartzBaseBean find(Integer id);

    List<QuartzBaseBean> findAll();

    int enable(Integer id);

    int disabled(Integer id);
}

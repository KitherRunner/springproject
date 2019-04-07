package com.kither.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Update("update user set active = '1' where id = 1")
    int avtiveUser(Integer id);
}

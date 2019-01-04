package com.kingdee.mapper;

import com.kingdee.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id, name, password, gender from user where id = #{id}")
    public User find(Integer id);
}

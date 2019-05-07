package com.kingdee.mapper;

import com.kingdee.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id,name,gender,salary,info from t_batch_user where id = #{id}")
    User find(Integer id);
}

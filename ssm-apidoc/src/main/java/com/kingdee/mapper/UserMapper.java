package com.kingdee.mapper;

import com.kingdee.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select id,name,password,gender from user where id = #{id}")
    User find(Integer id);

    @Update("update user set name = #{name}, password = #{password}, gender = #{gender} where id = #{id}")
    void Update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);
}

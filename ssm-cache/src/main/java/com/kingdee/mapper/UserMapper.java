package com.kingdee.mapper;

import com.kingdee.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select id,name,password,remark,gender from user where id = #{id}")
    User find(Integer id);

    @Insert("insert into user(name,password,remark,gender) values(#{name},#{password},#{remark},#{gender})")
    // 返回自增的主键并设置到user对象中
    @SelectKey(keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class, statement = " SELECT LAST_INSERT_ID()")
    void add(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    @Update("update user set name = #{name}, password = #{password}, remark = #{remark}, gender = #{gender} where id = #{id}")
    void update(User user);
}

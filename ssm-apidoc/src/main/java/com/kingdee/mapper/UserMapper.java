package com.kingdee.mapper;

import com.kingdee.bean.User;
import com.kingdee.sqlProvider.MapperSqlProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select id,name,password,gender from user where id = #{id}")
    User find(Integer id);

    @Update("update user set name = #{name}, password = #{password}, gender = #{gender} where id = #{id}")
    void Update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    /**
     * 使用@InsertProvider调用动态的insert SQL语句
     *
     * @param user
     */
    @InsertProvider(type = MapperSqlProvider.class, method = "addUser")
    @SelectKey(keyProperty = "id", keyColumn = "id", statement = "select last_insert_id()", resultType = Integer.class, before = false)
    void add(User user);
}

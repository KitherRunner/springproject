package com.kingdee.mapper;

import com.kingdee.bean.User;
import com.kingdee.mapper.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UserMapper {

    @InsertProvider(type = UserSqlProvider.class, method = "add")
    @SelectKey(keyColumn = "id", keyProperty = "id", statement = "select last_insert_ID()", before = false, resultType = Void.class)
    void add(User user);

    @Select("select id,name,gender from user where id = #{id}")
    User find(Integer id);
}

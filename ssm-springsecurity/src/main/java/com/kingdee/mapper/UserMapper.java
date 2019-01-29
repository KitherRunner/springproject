package com.kingdee.mapper;

import com.kingdee.bean.User;
import com.kingdee.sqlprovider.MapperSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface UserMapper {

    @SelectProvider(type = MapperSqlProvider.class, method = "find")
    User find(Integer id);
}

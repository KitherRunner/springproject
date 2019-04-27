package com.kingdee.mapper;

import com.kingdee.bean.User;
import com.kingdee.sqlprovider.UserSqlprovider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User find(Integer id);

    @SelectProvider(type = UserSqlprovider.class, method = "findAll")
    List<User> findAll();
}

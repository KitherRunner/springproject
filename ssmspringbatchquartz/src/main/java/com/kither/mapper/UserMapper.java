package com.kither.mapper;

import com.kither.bean.User;
import com.kither.mapper.sqlprovider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

@Mapper
public interface UserMapper {

    @SelectProvider(type = UserProvider.class, method = "findAll")
    List<User> findAll();

    @Select("select id, name, gender, info, salary from t_batch_user where id = #{id}")
    User find(Integer id);

    @UpdateProvider(type = UserProvider.class, method = "update")
    void update(User user);
}

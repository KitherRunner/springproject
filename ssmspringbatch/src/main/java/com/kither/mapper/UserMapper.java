package com.kither.mapper;

import com.kither.bean.User;
import com.kither.mapper.sqlprovider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @SelectProvider(type = UserProvider.class, method = "findAll")
    List<User> findAll();

    @Select("select id,name,gender,salary,info from t_batch_user where id = #{id}")
    User find(Integer id);

    @Insert("insert into t_batch_user(name,gender,salary,info) values(#{name},#{gender},#{salary},#{info})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void insert(User user);

    @Update("update t_batch_user set salary = #{salary},info = #{info} where id = #{id}")
    void update(User user);

    @Select("select id,name,gender,salary,info from t_batch_user limit #{index - 1},#{1}")
    User findOne(int index);
}

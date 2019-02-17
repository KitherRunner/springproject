package com.kingdee.mapper;

import com.kingdee.bean.User;
import com.kingdee.mapper.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /**
     * 动态sql的构建使用见：https://www.cnblogs.com/zhangminghui/p/4903351.html
     *
     * @param user
     */
    /**
     * 使用动态构建insert语句，指定生成sql语句的类及对应方法
     * @param user
     */
    @InsertProvider(type = UserSqlProvider.class, method = "add")
    // 设置主键自增，并且设置主键对应的列和属性，设置了这个注解就可以不需要下面的@SelectKey注解，会自动将自增的主键赋值到id属性中
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    // @SelectKey(keyColumn = "id", keyProperty = "id", statement = "select LAST_INSERT_ID()", before = false, resultType = Void.class) // 获取最后生成的主键值并赋值到id属性上
    void add(User user);

    @Select("select id,name,gender from user where id = #{id}")
    User find(Integer id);
}

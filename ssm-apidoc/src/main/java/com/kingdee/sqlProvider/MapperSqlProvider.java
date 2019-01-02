package com.kingdee.sqlProvider;

import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class MapperSqlProvider {

    public String addUser(User user) {
        return new SQL() {{

            INSERT_INTO("user"); // 插入数据的表
            INTO_COLUMNS("name", "password", "gender"); // 插入数据的字段
            // 对应的值(自己加引号)
            INTO_VALUES("\"" + user.getName() + "\"", "\"" + user.getPassword() + "\"", "\"" + user.getGender() + "\"");
        }}.toString();
    }
}

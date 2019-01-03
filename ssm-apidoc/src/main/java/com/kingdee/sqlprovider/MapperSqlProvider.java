package com.kingdee.sqlprovider;

import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class MapperSqlProvider {
    public String addUser(User user) {
        return new SQL() {{
            // 插入数据的表
            INSERT_INTO("user");
            // 插入数据的字段
            INTO_COLUMNS("name", "password", "gender");
            // 对应的值(自己加引号)
            INTO_VALUES("\"" + user.getName() + "\"", "\"" + user.getPassword() + "\"", user.getGender().toString());
        }}.toString();
    }
}

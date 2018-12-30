package com.kingdee.sqlProvider;

import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class MapperSqlProvider {

    public String addUser(User user) {
        return new SQL() {{

            INSERT_INTO("user");
            INTO_COLUMNS("name", "password", "gender");
            INTO_VALUES("\"" + user.getName() + "\"", "\"" + user.getPassword() + "\"", "\"" + user.getGender() + "\"");
        }}.toString();
    }
}

package com.kingdee.mapper.sqlprovider;

import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String add(User user) {
        return new SQL() {{
            INSERT_INTO("user");
            INTO_COLUMNS("name", "gender");
            INTO_VALUES(user.getName(), user.getGender());
        }}.toString();
    }
}

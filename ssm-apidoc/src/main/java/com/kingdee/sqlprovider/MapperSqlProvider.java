package com.kingdee.sqlprovider;

import com.google.common.base.Strings;
import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class MapperSqlProvider {
    public String addUser(final User user) {
        return new SQL() {{
            // 插入数据的表
            INSERT_INTO("user");
            if (!Strings.isNullOrEmpty(user.getName())) {
                VALUES("name", "#{name}");
            }
            if (!Strings.isNullOrEmpty(user.getPassword())) {
                VALUES("password", "#{password}");
            }
            if (user.getGender() != null) {
                VALUES("gender", "#{gender}");
            }
        }}.toString();
    }
}

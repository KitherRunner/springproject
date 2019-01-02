package com.kingdee.sqlprovider;

import com.google.common.base.Strings;
import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class MapperSqlProvider {

    /**
     * 动态构造添加用户信息的sql语句
     *
     * @param user
     * @return
     */
    public String addUser(User user) {
        return new SQL() {{
            INSERT_INTO("user");
            INTO_COLUMNS("name", "password", "gender");

            // 两头需要自己拼上字符串
            INTO_VALUES("\"" + user.getName() + "\"", "\"" + user.getPassword() + "\"", user.getGender().toString());
        }}.toString();
    }
}

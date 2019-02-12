package com.kingdee.mapper.sqlprovider;

import com.google.common.base.Strings;
import com.kingdee.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String add(final User user) {
        return new SQL() {{
            // 插入数据的表
            INSERT_INTO("user");
            if (!Strings.isNullOrEmpty(user.getName())) {
                // 对应的字段赋值，取出对象中的属性值与xml文件中一致
                VALUES("name", "#{name}");
            }
            if (!Strings.isNullOrEmpty(user.getGender())) {
                // 对应的字段赋值
                VALUES("gender", "#{gender}");
            }
        }}.toString();
    }
}

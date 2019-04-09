package com.kither.mapper.sqlprovider;

import com.kither.bean.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserProvider {

    public String findAll() {
        return new SQL() {{
            SELECT("id", "name", "gender", "salary", "info");
            FROM("t_batch_user");
        }}.toString();
    }

    public String update(final User user) {
        return new SQL() {{
            UPDATE("t_batch_user");
            if (!StringUtils.isEmpty(user.getName())) {
                SET("name = #{name}");
            }
            if (!StringUtils.isEmpty(user.getInfo())) {
                SET("info = #{info}");
            }
            if (user.getSalary() != null) {
                SET("salary = #{salary}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}

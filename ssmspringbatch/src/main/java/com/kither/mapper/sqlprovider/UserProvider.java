package com.kither.mapper.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String findAll() {
        return new SQL() {{
            SELECT("id", "name", "gender", "info", "salary");
            FROM("t_batch_user");
        }}.toString();
    }
}

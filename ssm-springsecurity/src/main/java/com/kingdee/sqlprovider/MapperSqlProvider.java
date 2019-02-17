package com.kingdee.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * 提供动态的sql语句
 */
public class MapperSqlProvider {

    public String find(Integer id) {
        return new SQL() {{
            SELECT("id", "name", "password", "remark");
            FROM("t_bd_user");
            WHERE("id = #{id} ");
        }}.toString();
    }
}

package com.kingdee.mapper;

import com.kingdee.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User find(Integer id);
}

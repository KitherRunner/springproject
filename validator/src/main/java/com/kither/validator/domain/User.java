package com.kither.validator.domain;

import com.kither.validator.group.UserGroup1;
import com.kither.validator.group.UserGroup2;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8822849393484517679L;

    private long userId;
    @NotEmpty(message = "userName 不能为空", groups = UserGroup1.class)
    private String userName;
    @NotEmpty(message = "password 不能为空", groups = {UserGroup1.class, UserGroup2.class})
    private String password;
    private byte gender;
    @Past(message = "birthday 必须是过去时间")
    private LocalDateTime birthday;
}

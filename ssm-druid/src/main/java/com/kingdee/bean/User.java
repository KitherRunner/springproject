package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户实体类")
public class User {
    @ApiModelProperty(value = "id", name = "编号", notes = "id", dataType = "int")
    private Integer id;
    @ApiModelProperty(value = "name", name = "姓名", notes = "name", dataType = "String")
    private String name;
    @ApiModelProperty(value = "password", name = "密码", notes = "password", dataType = "String")
    private String password;
    @ApiModelProperty(value = "gender", name = "性别", notes = "gender", dataType = "int")
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}

package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户实体类")
public class User {

    @ApiModelProperty(value = "编号", name = "id", notes = "id", dataType = "int")
    private Integer id;

    @ApiModelProperty(value = "姓名", name = "name", notes = "name", dataType = "String")
    private String name;

    @ApiModelProperty(value = "密码", name = "password", notes = "password", dataType = "String")
    private String password;

    @ApiModelProperty(value = "性别", name = "gender", notes = "gender", dataType = "int")
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

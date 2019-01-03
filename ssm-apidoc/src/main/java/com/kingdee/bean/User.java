package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "User ",description = "用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = 2684609809780170734L;

    @ApiModelProperty(name = "id",value = "编号",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(name = "name",value = "名称",dataType = "String")
    private String name;
    @ApiModelProperty(name = "password",value = "密码",dataType = "String")
    private String password;
    @ApiModelProperty(name = "gender",value = "性别(0男1女)",dataType = "Integer")
    private Integer gender;

    public User() {
    }

    public User(Integer id, String name, String password, Integer gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

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

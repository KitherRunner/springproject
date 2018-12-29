package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "User.class",description = "用户实体类")
public class User {
    @ApiModelProperty(name = "id",value = "编号",dataType = "int")
    private Integer id;

    @ApiModelProperty(name = "name",value = "名称",dataType = "String")
    private String name;

    @ApiModelProperty(name = "password",value = "密码",dataType = "String")
    private String password;

    @ApiModelProperty(name = "remark",value = "备注",dataType = "String")
    private String remark;

    @ApiModelProperty(name = "gender",value = "性别(0男1女)",dataType = "int")
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}

package com.kither.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "User", description = "用户类")
public class User implements Serializable {
    @ApiModelProperty(value = "ID", name = "id", notes = "用户ID", dataType = "int", example = "1")
    private Integer id;
    @ApiModelProperty(value = "名称", name = "name", notes = "用户名称", dataType = "String", example = "张三")
    private String name;
    @ApiModelProperty(value = "性别", name = "id", notes = "用户性别", dataType = "int", example = "1")
    private Integer gender;
    @ApiModelProperty(value = "说明", name = "info", notes = "用户说明", dataType = "string", example = "我是张三")
    private String info;
    @ApiModelProperty(value = "工资", name = "salary", notes = "用户工作", dataType = "bigdecimal", example = "1200.0")
    private BigDecimal salary;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

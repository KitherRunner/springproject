package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
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
}

package com.kingdee.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "user", description = "用户实体")
public class User implements Serializable {
    @ApiModelProperty(name = "id", value = "ID", notes = "用户编号", allowEmptyValue = false, dataType = "Integer", example = "1")
    private Integer id;
    @ApiModelProperty(name = "name", value = "用户名称", notes = "用户名称", allowEmptyValue = true, dataType = "String", example = "张三")
    private String name;
    @ApiModelProperty(name = "gender", value = "用户性别", notes = "用户性别", allowEmptyValue = true, dataType = "String", example = "male")
    private String gender;
}

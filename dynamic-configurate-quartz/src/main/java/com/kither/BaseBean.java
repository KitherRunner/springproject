package com.kither;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "BaseBean", description = "bean基类", parent = Serializable.class)
public class BaseBean implements Serializable {
    private static final long serialVersionUID = 5475051710874310368L;
    @ApiModelProperty(value = "id", name = "ID", notes = "唯一主键", dataType = "int", required = true, readOnly = true)
    private Integer id;
    @ApiModelProperty(value = "number", name = "编码", notes = "编码", dataType = "string", required = true, readOnly = false)
    private String number; // 编码
    @ApiModelProperty(value = "name", name = "名称", notes = "名称", dataType = "string", required = true, readOnly = false)
    private String name; // 名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

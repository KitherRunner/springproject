package com.kither.bean;

import com.kither.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "LogInfo", description = "日志记录类", parent = BaseBean.class)
public class LogInfo extends BaseBean {
    private static final long serialVersionUID = 6560964795425326421L;
    @ApiModelProperty(value = "operate", name = "操作", notes = "操作", dataType = "string", required = true, readOnly = true)
    private String operate; // 操作
    @ApiModelProperty(value = "desc", name = "描述", notes = "描述", dataType = "string", required = true, readOnly = true)
    private String desc; // 描述
    @ApiModelProperty(value = "operateDate", name = "操作时间", notes = "操作时间", dataType = "date", required = true, readOnly = true)
    private Date operateDate; // 操作时间
    @ApiModelProperty(value = "operator", name = "操作人", notes = "操作人", dataType = "string", required = true, readOnly = true)
    private String operator; // 操作人
    @ApiModelProperty(value = "state", name = "状态", notes = "状态", dataType = "int", required = true, readOnly = true)
    private Integer state; // 1：成功/0：失败

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

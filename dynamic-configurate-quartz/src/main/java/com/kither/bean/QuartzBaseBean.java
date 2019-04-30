package com.kither.bean;

import com.kither.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "QuartzBaseBean", description = "自动任务类", parent = BaseBean.class)
public class QuartzBaseBean extends BaseBean {
    private static final long serialVersionUID = -8097035489845357956L;
    @ApiModelProperty(value = "startDate", name = "开始时间", notes = "开始时间", dataType = "date", required = true, readOnly = false)
    private Date startDate; // 开始时间
    @ApiModelProperty(value = "endDate", name = "endDate", notes = "endDate", dataType = "date", required = false, readOnly = false)
    private Date endDate; // 结束时间
    @ApiModelProperty(value = "state", name = "状态", notes = "状态", dataType = "int", required = true, readOnly = false)
    private Integer state; // 1:启用；2:禁用
    @ApiModelProperty(value = "exeLink", name = "执行地址", notes = "执行地址", dataType = "string", required = true, readOnly = false)
    private String exeLink; // 执行地址
    @ApiModelProperty(value = "cronExpression", name = "cron表达式", notes = "cron表达式", dataType = "string", required = true, readOnly = false)
    private String cronExpression; // cron表达式
    @ApiModelProperty(value = "desc", name = "描述", notes = "描述", dataType = "string", required = false, readOnly = false)
    private String desc; // 描述
    @ApiModelProperty(value = "retryCount", name = "重试次数", notes = "重试次数", dataType = "int", required = false, readOnly = false)
    private Integer retryCount; // 重试次数

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getExeLink() {
        return exeLink;
    }

    public void setExeLink(String exeLink) {
        this.exeLink = exeLink;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }
}

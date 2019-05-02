package com.kither.bean;

import com.kither.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CodeRule", description = "编码规则类", parent = BaseBean.class)
public class CodeRule extends BaseBean {

    private static final long serialVersionUID = -2536669892691679845L;
    @ApiModelProperty(value = "billType", name = "单据类型", notes = "单据类型", dataType = "string", required = true, readOnly = false)
    private String billType; // 单据类型
    @ApiModelProperty(value = "lastUpdateTime", name = "最后修改时间", notes = "最后修改时间", dataType = "date", required = false, readOnly = false)
    private Date lastUpdateTime; // 最后修改时间
    @ApiModelProperty(value = "serialNuo", name = "编号", notes = "编号", dataType = "string", required = false, readOnly = false)
    private Integer serialNo; // 编号
    @ApiModelProperty(value = "createDate", name = "创建时间", notes = "创建时间", dataType = "date", required = false, readOnly = false)
    private Date createDate; // 创建时间
    @ApiModelProperty(value = "length", name = "长度", notes = "长度", dataType = "int", required = true, readOnly = false)
    private Integer length; // 长度
    @ApiModelProperty(value = "prefix", name = "前缀", notes = "前缀", dataType = "string", required = false, readOnly = false)
    private String prefix;// 前缀

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "CodeRule{" +
                "billType='" + billType + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", serialNuo=" + serialNo +
                ", createDate=" + createDate +
                ", length=" + length +
                ", id=" + getId() +
                ", number=" + getNumber() +
                ", name=" + getName() +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}

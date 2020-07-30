package com.caifu.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 军休活动参与成员
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
public class JxActivityMenber extends Model<JxActivityMenber> {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人
     */
    @TableField("CREATE_BY")
    @ExcelIgnore
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "报名时间", index = 4)
    @ColumnWidth(25)
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("UPDATE_BY")
    @ExcelIgnore
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private Date updateTime;

    /**
     * 主键id
     */
    @ExcelIgnore
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动id（JX_ACTIVITY.ID）
     */
    @ExcelIgnore
    @TableField("ACTIVITY_ID")
    private Integer activityId;

    /**
     * 姓名
     */
    @TableField("NAME")
    @ExcelProperty(value = "用户姓名", index = 0)
    @ColumnWidth(15)
    private String name;

    /**
     * 手机号码
     */
    @TableField("MOBILE")
    @ExcelProperty(value = "手机号", index = 1)
    @ColumnWidth(20)
    private String mobile;

    /**
     * 随行人数
     */
    @ExcelIgnore
    @TableField("ACCOMPANYING_NUMBER")
    private Integer accompanyingNumber;

    /**
     * 随行人姓名
     */
    @TableField("ACCOMPANYING_NAMES")
    @ExcelProperty(value = "随行人信息", index = 2)
    @ColumnWidth(20)
    private String accompanyingNames;

    /**
     * 备注
     */
    @TableField("REMARKS")
    @ExcelProperty(value = "备注", index = 3)
    private String remarks;

    /**
     * 状态（1.参与   9.取消参与）
     */
    @TableField("STATUS")
    @ExcelIgnore
    private String status;

    /**
     * 取消时间
     */
    @ExcelIgnore
    @TableField("CANCEL_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cancelTime;

    /**
     * 用户编号（SYS_WECHAT_USER.USER_NO）
     */
    @ExcelIgnore
    @TableField("USER_NO")
    private Integer userNo;

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAccompanyingNumber() {
        return accompanyingNumber;
    }

    public void setAccompanyingNumber(Integer accompanyingNumber) {
        this.accompanyingNumber = accompanyingNumber;
    }

    public String getAccompanyingNames() {
        return accompanyingNames;
    }

    public void setAccompanyingNames(String accompanyingNames) {
        this.accompanyingNames = accompanyingNames;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxActivityMenber{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", activityId=" + activityId +
                ", name=" + name +
                ", mobile=" + mobile +
                ", accompanyingNumber=" + accompanyingNumber +
                ", accompanyingNames=" + accompanyingNames +
                ", remarks=" + remarks +
                ", status=" + status +
                ", cancelTime=" + cancelTime +
                ", userNo=" + userNo +
                "}";
    }
}

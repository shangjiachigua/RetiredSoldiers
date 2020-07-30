package com.caifu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 军休活动
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-23
 */
public class JxActivity extends Model<JxActivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人
     */
    @TableField("CREATE_BY")
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("UPDATE_BY")
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 展示图片
     */
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     * 活动标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 活动地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 活动室
     */
    @TableField("ROOM_NO")
    private Integer roomNo;

    /**
     * 联系方式
     */
    @TableField("CONTACT_INFORMATION")
    private String contactInformation;

    /**
     * 是否需要随行人（0.否  1.是）
     */
    @TableField("ACCOMPANYING")
    private String accompanying;

    /**
     * 活动招募人数
     */
    @TableField("RECRUITS_NUMBER")
    private Integer recruitsNumber;

    /**
     * 招募开始时间
     */
    @TableField("RECRUITS_START_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recruitsStartTime;

    /**
     * 招募结束时间
     */
    @TableField("RECRUITS_END_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recruitsEndTime;

    /**
     * 活动开始时间
     */
    @TableField("ACTIVITY_START_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;

    /**
     * 活动结束时间
     */
    @TableField("ACTIVITY_END_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;

    /**
     * 活动描述
     */
    @TableField("ACTIVITY_DESCRIBE")
    private String activityDescribe;

    /**
     * 活动详情
     */
    @TableField("DETAILS")
    private String details;

    /**
     * 状态（0.待发布  1.发布  9.删除）
     */
    @TableField("STATUS")
    private String status;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAccompanying() {
        return accompanying;
    }

    public void setAccompanying(String accompanying) {
        this.accompanying = accompanying;
    }

    public Integer getRecruitsNumber() {
        return recruitsNumber;
    }

    public void setRecruitsNumber(Integer recruitsNumber) {
        this.recruitsNumber = recruitsNumber;
    }

    public Date getRecruitsStartTime() {
        return recruitsStartTime;
    }

    public void setRecruitsStartTime(Date recruitsStartTime) {
        this.recruitsStartTime = recruitsStartTime;
    }

    public Date getRecruitsEndTime() {
        return recruitsEndTime;
    }

    public void setRecruitsEndTime(Date recruitsEndTime) {
        this.recruitsEndTime = recruitsEndTime;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getActivityDescribe() {
        return activityDescribe;
    }

    public void setActivityDescribe(String activityDescribe) {
        this.activityDescribe = activityDescribe;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxActivity{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", id=" + id +
                ", imgUrl=" + imgUrl +
                ", title=" + title +
                ", address=" + address +
                ", roomNo=" + roomNo +
                ", contactInformation=" + contactInformation +
                ", accompanying=" + accompanying +
                ", recruitsNumber=" + recruitsNumber +
                ", recruitsStartTime=" + recruitsStartTime +
                ", recruitsEndTime=" + recruitsEndTime +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", activityDescribe=" + activityDescribe +
                ", details=" + details +
                ", status=" + status +
                "}";
    }
}

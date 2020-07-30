package com.caifu.dto;

import java.util.Date;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName JxActivityDto.java
 * @createTime 2020年07月23日 09:54
 **/
public class JxActivityDto {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 展示图片
     */
    private String imgUrl;
    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 活动开始时间
     */
    private Date activityStartTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 活动描述
     */
    private String activityDescribe;

    /**
     * 活动招募人数
     */
    private Integer recruitsNumber;

    /**
     * 活动已招募人数
     */
    private Integer recruitsCountNumber;

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

    public Integer getRecruitsNumber() {
        return recruitsNumber;
    }

    public void setRecruitsNumber(Integer recruitsNumber) {
        this.recruitsNumber = recruitsNumber;
    }

    public Integer getRecruitsCountNumber() {
        return recruitsCountNumber;
    }

    public void setRecruitsCountNumber(Integer recruitsCountNumber) {
        this.recruitsCountNumber = recruitsCountNumber;
    }
}

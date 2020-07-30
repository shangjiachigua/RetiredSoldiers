package com.caifu.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName JxJournalismDto.java
 * @createTime 2020年07月22日 14:15
 **/
public class JxJournalismDto {
    /**
     * 标题
     */
    private String title;

    /**
     * 浏览量
     */
    private Integer browseNumber;

    /**
     * 点赞量
     */
    private Integer niceNumber;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 是否置顶（0.否   1.是）
     */
    private String isTop;

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

    public Integer getNiceNumber() {
        return niceNumber;
    }

    public void setNiceNumber(Integer niceNumber) {
        this.niceNumber = niceNumber;
    }
}

package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 新闻信息表
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-22
 */
public class JxJournalism extends Model<JxJournalism> {

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
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 简介
     */
    @TableField("BRIEF_INTRODUCTION")
    private String briefIntroduction;

    /**
     * 内容
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 图片
     */
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     * 置顶图片
     */
    @TableField("TOP_IMG_URL")
    private String topImgUrl;

    /**
     * 是否置顶（0.否   1.是）
     */
    @TableField("IS_TOP")
    private String isTop;

    /**
     * 状态（1.正常   9.删除）
     */
    @TableField("STATUS")
    private String status;

    /**
     * 浏览量
     */
    @TableField("BROWSE_NUMBER")
    private Integer browseNumber;

    /**
     * 类型(1.内链  2.外链)
     */
    @TableField("TYPE")
    private String type;

    /**
     * 外链url
     */
    @TableField("URL")
    private String url;

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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getTopImgUrl() {
        return topImgUrl;
    }

    public void setTopImgUrl(String topImgUrl) {
        this.topImgUrl = topImgUrl;
    }
    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxJournalism{" +
        "createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", id=" + id +
        ", title=" + title +
        ", briefIntroduction=" + briefIntroduction +
        ", content=" + content +
        ", imgUrl=" + imgUrl +
        ", topImgUrl=" + topImgUrl +
        ", isTop=" + isTop +
        ", status=" + status +
        ", browseNumber=" + browseNumber +
        ", type=" + type +
        ", url=" + url +
        "}";
    }
}

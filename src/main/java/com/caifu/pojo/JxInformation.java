package com.caifu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 军休资料
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
public class JxInformation extends Model<JxInformation> {

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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 资料标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 资料类型（关联JX_INFORMATION_TYPE.ID）
     */
    @TableField("TYPE")
    private String type;

    /**
     * 资料简介
     */
    @TableField("BRIEF_INTRODUCTION")
    private String briefIntroduction;

    /**
     * 资料内容
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 状态（1.正常 2.删除）
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "JxInformation{" +
        "createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", id=" + id +
        ", title=" + title +
        ", type=" + type +
        ", briefIntroduction=" + briefIntroduction +
        ", content=" + content +
        ", status=" + status +
        "}";
    }
}

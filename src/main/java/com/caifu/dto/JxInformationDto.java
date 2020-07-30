package com.caifu.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author tianwenwen
 * @version 1.0.0
 * @ClassName JxInformation.java
 * @createTime 2020年07月27日 15:32
 **/
public class JxInformationDto {
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
     * 文件url
     */
    @TableField("FILE_URL")
    private String fileUrl;

    /**
     * 文件名称
     */
    @TableField("NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}

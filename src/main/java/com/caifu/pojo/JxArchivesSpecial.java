package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 特殊情况表 
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public class JxArchivesSpecial extends Model<JxArchivesSpecial> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 档案id
     */
    @TableField("ARCHIVES_ID")
    private Integer archivesId;

    /**
     * 特殊情况
     */
    @TableField("SPECIAL")
    private String special;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(Integer archivesId) {
        this.archivesId = archivesId;
    }
    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxArchivesSpecial{" +
        "id=" + id +
        ", archivesId=" + archivesId +
        ", special=" + special +
        "}";
    }
}

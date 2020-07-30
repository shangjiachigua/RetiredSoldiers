package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 参战情况表
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public class JxArchivesWarfare extends Model<JxArchivesWarfare> {

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
     * 参战情况
     */
    @TableField("WARFARE")
    private String warfare;

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
    public String getWarfare() {
        return warfare;
    }

    public void setWarfare(String warfare) {
        this.warfare = warfare;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxArchivesWarfare{" +
        "id=" + id +
        ", archivesId=" + archivesId +
        ", warfare=" + warfare +
        "}";
    }
}

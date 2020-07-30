package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 家庭成员表
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public class JxArchivesFamilymembers extends Model<JxArchivesFamilymembers> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 档案ID
     */
    @TableField("ARCHIVES_ID")
    private Integer archivesId;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 家属关系
     */
    @TableField("RELATION")
    private String relation;

    /**
     * 联系方式
     */
    @TableField("CONTACT")
    private String contact;

    /**
     * 是否紧急联系人(0.否1.是)
     */
    @TableField("URGENT_CONTACT")
    private String urgentContact;

    /**
     * 状态（1.正常 9.删除）
     */
    @TableField("STATUS")
    private String status;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getUrgentContact() {
        return urgentContact;
    }

    public void setUrgentContact(String urgentContact) {
        this.urgentContact = urgentContact;
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
        return "JxArchivesFamilymembers{" +
        "id=" + id +
        ", archivesId=" + archivesId +
        ", name=" + name +
        ", relation=" + relation +
        ", contact=" + contact +
        ", urgentContact=" + urgentContact +
        ", status=" + status +
        "}";
    }
}

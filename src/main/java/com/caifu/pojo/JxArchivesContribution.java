package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 立功表
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public class JxArchivesContribution extends Model<JxArchivesContribution> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 档案ID
     */
    @TableField("ARCHIVES_ID")
    private Integer archivesId;

    /**
     * 立功时间
     */
    @TableField("CONTRIBUTION_DATE")
    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private Date contributionDate;

    /**
     * 立功等级
     */
    @TableField("CONTRIBUTION_LEVEL")
    private String contributionLevel;

    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;

    /**
     * 状态（1.正常   9.删除）
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
    public Date getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(Date contributionDate) {
        this.contributionDate = contributionDate;
    }
    public String getContributionLevel() {
        return contributionLevel;
    }

    public void setContributionLevel(String contributionLevel) {
        this.contributionLevel = contributionLevel;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxArchivesContribution{" +
        "id=" + id +
        ", archivesId=" + archivesId +
        ", contributionDate=" + contributionDate +
        ", contributionLevel=" + contributionLevel +
        ", remarks=" + remarks +
        ", status=" + status +
        "}";
    }
}

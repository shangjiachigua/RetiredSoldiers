package com.caifu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 主键id
     */
    @TableId(value = "MENU_NO", type = IdType.AUTO)
    private Integer menuNo;

    /**
     * 菜单名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 菜单类型(1.目录 2.菜单 3.按钮)
     */
    @TableField("TYPE")
    private String type;

    /**
     * 父级id
     */
    @TableField("PARENT_NO")
    private Integer parentNo;

    /**
     * 菜单url
     */
    @TableField("URL")
    private String url;

    /**
     * 权限代码
     */
    @TableField("PERMISSION_CODE")
    private String permissionCode;

    /**
     * 菜单图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 状态（1.正常 9.删除）
     */
    @TableField("STATUS")
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.menuNo;
    }

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

    public Integer getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Integer menuNo) {
        this.menuNo = menuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParentNo() {
        return parentNo;
    }

    public void setParentNo(Integer parentNo) {
        this.parentNo = parentNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

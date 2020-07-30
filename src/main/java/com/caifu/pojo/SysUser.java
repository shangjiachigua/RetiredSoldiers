package com.caifu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 用户表 用户表
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

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
     * 最后登录时间
     */
    @TableField("LOGIN_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    /**
     * 主键id
     */
    @TableId(value = "USER_NO", type = IdType.AUTO)
    //@TableId(type = IdType.AUTO) 主键自增 数据库中需要设置主键自增
    //@TableId(type = IdType.UUID) UUID类型主键
    //@TableId(type = IdType.INPUT) 用户自定义了  数据类型和数据库保持一致就行
    private Integer userNo;

    /**
     * 用户名（登录账号）
     */
    @TableField("LOGIN_NAME")
    private String loginName;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 加密盐
     */
    @TableField("SALT")
    private String salt;

    /**
     * 姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 明文密码
     */
    @TableField("PAW")
    private String paw;

    /**
     * 状态（1.正常 9.删除）
     */
    @TableField("STATUS")
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.userNo;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

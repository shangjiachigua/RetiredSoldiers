package com.caifu.sys.sysController;

import com.caifu.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * @Author:debug
 * @Date: 2019/7/30 12:23
 **/
@Controller
public abstract class AbstractController {

    //日志
    protected Logger log= LoggerFactory.getLogger(getClass());

    //获取当前登录用户的详情
    protected SysUser getUser(){
        SysUser user= (SysUser) SecurityUtils.getSubject().getPrincipal();
        user.setPassword("");
        user.setPaw("");
        user.setSalt("");
        return user;
    }



    /**
     * 判断当前登录用户（主体）是否有 指定的权限
     * @param permission 指定的权限
     * @return
     */
    public Boolean hasPermission(String permission){
        Subject subject= SecurityUtils.getSubject();
        return (subject!=null && subject.isPermitted(permission))? true : false;
    }


    protected String getUserName(){
        return getUser().getUserName();
    }
    protected String getLoginName(){
        return getUser().getLoginName();
    }
    protected int getUserNo(){
        return getUser().getUserNo();
    }

}
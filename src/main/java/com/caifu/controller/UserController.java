package com.caifu.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.caifu.common.Result;
import com.caifu.common.ResultUtil;
import com.caifu.pojo.SysUser;
import com.caifu.service.SysMenuService;
import com.caifu.service.SysUserService;
import com.caifu.sys.sysController.AbstractController;
import com.caifu.util.ShiroUtil;
import com.caifu.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lyf
 * @Date: 2020/7/14 16:02
 * @Description: 用户管理控制层
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysMenuService menuService;

    @RequestMapping("/index")
    @RequiresPermissions("yonghuguanli")
    public String index(String initPage,ModelMap map){
        map.put("initPage",initPage);
        return "view/user/index";
    }

    @RequestMapping("/userMenu")
    @RequiresPermissions("yonghuguanli")
    public String userMenu(ModelMap map,String userNo,String userPage){
        map.put("userNo",userNo);
        map.put("userPage",userPage);
        return "view/user/userMenu";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result getUserList(int currentPage,int pageSize,String userName){
        try{
            //获取用户信息列表
            return ResultUtil.success("data",userService.getUserList(currentPage,pageSize,userName));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取用户列表失败！");
            return ResultUtil.error(199,"获取用户列表失败！");
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result save(String userNo,String userName,String loginName){
        try{
            int loginNameCount;
            boolean flag = true;
            SysUser user = null;
            if(StringUtils.isNotBlank(userNo)) {
                //修改用户信息
                loginNameCount = userService.getCountByLoginName(loginName,userNo);
                if(loginNameCount <= 0) {
                    user = userService.getById(userNo);
                    user.setUpdateBy(getUserNo());
                    user.setUpdateTime(new Date());
                    user.setLoginName(loginName);
                    user.setUserName(userName);
                }else{
                    flag = false;
                }
            }else{
                //新增用户信息
                loginNameCount = userService.getCountByLoginName(loginName,null);
                if(loginNameCount <= 0) {
                    user = new SysUser();
                    user.setCreateTime(new Date());
                    user.setLoginName(loginName);
                    user.setUserName(userName);
                    user.setPaw("111111");
                    String salt = Util.getStringRandom(20);
                    String password = ShiroUtil.sha256("111111", salt);
                    user.setSalt(salt);
                    user.setPassword(password);
                    user.setCreateBy(getUserNo());
                    user.setStatus("1");
                }else{
                    flag = false;
                }
            }
            if(flag) {
                userService.saveOrUpdate(user);
                return ResultUtil.success(200, "用户信息保存成功！");
            }else{
                return ResultUtil.error(198,"用户账号已存在,保存失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("用户信息保存失败！");
            return ResultUtil.error(199,"用户信息保存失败！");
        }
    }


    @RequestMapping("/getUserById")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result getUserById(String userNo){
        try{
            //根据用户编号获取用户信息
            return ResultUtil.success(200, "获取用户信息成功！",userService.getById(userNo));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取用户信息失败！");
            return ResultUtil.error(199,"获取用户信息失败！");
        }
    }

    @RequestMapping("/setUserMenu")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result setUserMenu(int userNo,String menus){
        try{
            //菜单权限配置
            userService.setUserMenu(userNo,menus);
            return ResultUtil.success(200, "菜单权限配置成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("菜单权限配置失败！");
            return ResultUtil.error(199,"菜单权限配置失败！");
        }
    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result resetPassword(String userNo){
        try{
            //重置密码
            String salt = Util.getStringRandom(20);
            String password = ShiroUtil.sha256("111111", salt);
            return ResultUtil.success(200, "密码重置成功！",userService.update(new UpdateWrapper<SysUser>().lambda().set(SysUser::getPaw,"111111").set(SysUser::getSalt,salt).set(SysUser::getPassword,password).eq(SysUser::getUserNo,userNo)));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("密码重置失败！");
            return ResultUtil.error(199,"密码重置失败！");
        }
    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public Result changePassword(String newPassword){
        try{
            //重置密码
            int userNo = getUserNo();
            String salt = Util.getStringRandom(20);
            String password = ShiroUtil.sha256(newPassword, salt);
            return ResultUtil.success(200, "密码修改成功！",userService.update(new UpdateWrapper<SysUser>().lambda().set(SysUser::getPaw,newPassword).set(SysUser::getSalt,salt).set(SysUser::getPassword,password).eq(SysUser::getUserNo,userNo)));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("密码修改失败！");
            return ResultUtil.error(199,"密码修改失败！");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result delete(String userNo){
        try{
            //逻辑删除
            return ResultUtil.success(200, "删除用户成功！",userService.update(new UpdateWrapper<SysUser>().lambda().set(SysUser::getStatus,"9").eq(SysUser::getUserNo,userNo)));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除用户失败！");
            return ResultUtil.error(199,"删除用户失败！");
        }
    }

    @RequestMapping("/getUserMenu")
    @ResponseBody
    @RequiresPermissions("yonghuguanli")
    public Result getUserMenu(int userNo){
        try{
            List<Map<String,String>> list = menuService.getUserMenu(userNo);
            //获取菜单（全部菜单）
            return ResultUtil.success(200, "获取菜单成功！",list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取菜单失败！");
            return ResultUtil.error(199,"获取菜单失败！");
        }
    }
}

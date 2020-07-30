package com.caifu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caifu.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 用户表 服务类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 功能描述: 根据用户登录名获取用户信息
     *
     * @auther: Lyf
     * @date: 2020/7/7 15:27
     * @param:
     * @return:
     */
    SysUser getUserByLoginName(String loginName)throws Exception;

    /**
     * 功能描述: 根据查询条件查询用户列表
     *
     * @auther: Lyf
     * @date: 2020/7/14 16:33
     * @param:
     * @return:
     */
    IPage<SysUser> getUserList(int currentPage, int pageSize, String userName)throws Exception;

    /**
     * 功能描述: 更新最后登录时间
     *
     * @auther: Lyf
     * @date: 2020/7/14 18:11
     * @param:
     * @return:
     */
    void updateLoginTime(String loginName)throws Exception;

    /**
     * 功能描述: 根据用户账号获取用户记录数（如果userNo不为空，那么将排查userNo 记录）
     *
     * @auther: Lyf
     * @date: 2020/7/15 12:25
     * @param:
     * @return:
     */
    int getCountByLoginName(String loginName,String userNo)throws Exception;

    /**
     * 功能描述: 设置用户菜单权限
     *
     * @auther: Lyf
     * @date: 2020/7/16 13:06
     * @param:
     * @return:
     */
    void setUserMenu(int userNo,String menus)throws Exception;
}

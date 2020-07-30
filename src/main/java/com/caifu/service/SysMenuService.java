package com.caifu.service;

import com.caifu.pojo.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 功能描述: 根据用户编号获取用户菜单权限
     *
     * @auther: Lyf
     * @date: 2020/7/15 16:21
     * @param:
     * @return:
     */
    List<SysMenu> getMenuByUser(int userNo) throws Exception;

    /**
     * 功能描述: 获取所有菜单，根据用户编号查询用户与菜单的关系
     *
     * @auther: Lyf
     * @date: 2020/7/15 16:21
     * @param:
     * @return:
     */
    List<Map<String,String>> getUserMenu(int userNo) throws Exception;

}

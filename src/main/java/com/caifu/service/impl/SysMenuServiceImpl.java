package com.caifu.service.impl;

import com.caifu.pojo.SysMenu;
import com.caifu.mapper.SysMenuMapper;
import com.caifu.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenuByUser(int userNo) throws Exception{
        try{
            return menuMapper.getMenuByUser(userNo);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取用户菜单失败！");
        }
    }

    @Override
    public List<Map<String, String>> getUserMenu(int userNo) throws Exception{
        try{
            return menuMapper.getUserMenu(userNo);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取菜单失败！");
        }
    }
}

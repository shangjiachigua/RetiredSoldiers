package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caifu.mapper.SysUserMenuMapper;
import com.caifu.pojo.SysUser;
import com.caifu.mapper.SysUserMapper;
import com.caifu.pojo.SysUserMenu;
import com.caifu.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户表 用户表 服务实现类
 * </p>
 *
 * @author Lyf
 * @since 2020-07-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserMenuMapper userMenuMapper;

    @Override
    @Transactional
    public SysUser getUserByLoginName(String loginName) throws Exception{
        try {
            return userMapper.selectOne(new QueryWrapper<SysUser>().eq("login_name",loginName).eq("status","1"));
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取用户信息失败！");
        }
    }

    @Override
    @Transactional
    public IPage<SysUser> getUserList(int currentPage, int pageSize, String userName)throws Exception {
        try {
            Page<SysUser> page = new Page<>(currentPage,pageSize);
            if(StringUtils.isNotBlank(userName)){
                return userMapper.selectPage(page,new QueryWrapper<SysUser>().like("user_name",userName).eq("status","1").orderByAsc("user_no"));
            }else{
                return userMapper.selectPage(page,new QueryWrapper<SysUser>().eq("status","1").orderByAsc("user_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("获取用户信息失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLoginTime(String loginName) throws Exception {
        try{
            UpdateWrapper<SysUser> uw = new UpdateWrapper<>();
            uw.lambda().set(SysUser::getLoginTime,new Date()).eq(SysUser::getLoginName,loginName);
            userMapper.update(null,uw);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("更新最后登录时间失败！");
        }
    }

    @Override
    @Transactional
    public int getCountByLoginName(String loginName, String userNo) throws Exception {
        try {
            QueryWrapper qw = new QueryWrapper<SysUser>();
            qw.eq("login_name",loginName);
            if(StringUtils.isNotBlank(userNo)){
              qw.ne("user_no",userNo);
            }
            return userMapper.selectCount(qw);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("获取用户信息失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setUserMenu(int userNo, String menus) throws Exception {
        try {
            userMenuMapper.delete(new UpdateWrapper<SysUserMenu>().eq("user_no",userNo));
            if (StringUtils.isNotBlank(menus)) {
                String[] menuArr = menus.split(",");
                if(menuArr != null && menuArr.length > 0){
                    for(String s : menuArr){
                        SysUserMenu sum = new SysUserMenu();
                        sum.setUserNo(userNo);
                        sum.setMenuNo(Integer.parseInt(s));
                        userMenuMapper.insert(sum);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("配置用户菜单权限失败！");
        }
    }
}

package com.caifu.sys.shiro;

import com.caifu.pojo.SysMenu;
import com.caifu.pojo.SysUser;
import com.caifu.service.SysMenuService;
import com.caifu.service.SysUserService;
import com.caifu.util.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CustomRealm extends AuthorizingRealm{

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysMenuService menuService;

    /*@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        String loginName = user.getLoginName();
        //根据用户名去数据库查询用户信息
        SysUser user = loginService.getUserByName(loginName);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permissions permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
        }
        return simpleAuthorizationInfo;
    }*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        try {
            //获取登录用户名
            SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
            //添加角色和权限
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

            List<SysMenu> list = menuService.getMenuByUser(user.getUserNo());
            for (SysMenu menu : list) {
                //添加角色
                //simpleAuthorizationInfo.addRole(role.getRoleName());
                //添加权限
                simpleAuthorizationInfo.addStringPermission(menu.getPermissionCode());
            }
            return simpleAuthorizationInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String loginName = authenticationToken.getPrincipal().toString();
        SysUser user = null;
        try{
            user = userService.getUserByLoginName(loginName);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (user == null) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException("账户不存在!");
        } else {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
            return info;
        }
    }

    /**
     * 密码验证器
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}

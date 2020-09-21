package com.zj.jingyuesystem.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.jingyuesystem.sys.entity.SysMenu;
import com.zj.jingyuesystem.sys.entity.SysShiroUser;
import com.zj.jingyuesystem.sys.entity.SysUser;
import com.zj.jingyuesystem.sys.service.ISysMenuService;
import com.zj.jingyuesystem.sys.service.ISysUserRoleService;
import com.zj.jingyuesystem.sys.service.ISysUserService;
import com.zj.jingyuesystem.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    ISysUserService iSysUserService;


    @Autowired
    ISysUserRoleService iSysUserRoleService;

    @Autowired
    ISysMenuService iSysMenuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysShiroUser shiroUser = (SysShiroUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (shiroUser.getRoleID() != null) {
            info.addRole(String.valueOf(shiroUser.getRoleID()));
        }
        Long roleID = shiroUser.getRoleID();
        List<SysMenu> menus = iSysMenuService.selectMenusById(roleID);

        if (!menus.isEmpty()) {
            for (SysMenu menu : menus) {
                info.addStringPermission(menu.getPerms());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", username);
        SysUser user = iSysUserService.getOne(queryWrapper);
        System.out.println(user.getLoginName());
        Long maxRoleId = null;
        List<SysMenu> menus = new ArrayList<>();
        Set<String> permSet = new HashSet<>();
        if (user != null) {
            // role_id字段默认越小角色权限越大
            List<Long> roleIds = iSysUserRoleService.selectList(user.getUserId());
            maxRoleId = roleIds.get(0);
        }

        if (maxRoleId != null) {
            menus = iSysMenuService.selectMenusById(maxRoleId);
        }
        SysShiroUser shiroUser = ShiroUtils.mergeUser(user, maxRoleId, menus);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, password, getName());
        System.out.println("==============认证账户===");
        return authenticationInfo;
    }
}

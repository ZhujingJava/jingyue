package com.zj.jingyuesystem.utils;

import com.zj.jingyuesystem.sys.entity.SysMenu;
import com.zj.jingyuesystem.sys.entity.SysShiroUser;
import com.zj.jingyuesystem.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.Assert;
import org.springframework.beans.BeanUtils;

import java.util.List;


public class ShiroUtils {

    public static SysShiroUser getShiroUser(){
        return (SysShiroUser) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }
    public  static SysShiroUser  mergeUser(SysUser sysUser, Long roleId, List<SysMenu> menus){
        SysShiroUser shiroUser=new SysShiroUser();
        Assert.notNull(sysUser,"传入的用户为空");
        BeanUtils.copyProperties(sysUser,shiroUser);
        shiroUser.setRoleID(roleId);
        shiroUser.setMenus(menus);
          return shiroUser;
        /* user.setUserId(sysUser.getUserId());
         user.setAvatar(sysUser.getAvatar());
         user.setCreateBy(sysUser.getCreateBy());
         user.setDelFlag(sysUser.getDelFlag());
         user.setDeptId(sysUser.getDeptId());
         user.setEmail(sysUser.getEmail());
         user.setLoginIp(sysUser.getLoginIp());
         user.setLoginName(sysUser.getLoginName());
         user.setPassword(sysUser.getPassword());
         user.setRoleID(roleId);
         user.setMenus(menus);
         user.setUserName(sysUser.getUserName());
         user.setPhonenumber(sysUser.getPhonenumber());
         user.setRemark(sysUser.getRemark());
         user.setSalt(sysUser.getSalt());*/
    }


}

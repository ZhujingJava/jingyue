package com.zj.sys.web.controller;

import com.zj.jingyuecommon.util.GlobalException;
import com.zj.jingyuesystem.annotation.Logger;
import com.zj.jingyuesystem.sys.entity.SysMenu;
import com.zj.jingyuesystem.sys.entity.SysShiroUser;
import com.zj.jingyuesystem.sys.service.ISysMenuService;
import com.zj.jingyuesystem.sys.service.ISysUserService;
import com.zj.jingyuesystem.utils.MenuTreeUtil;
import com.zj.jingyuesystem.utils.ShiroUtils;
import com.zj.jingyuesystem.utils.SysMenuItem;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    ISysMenuService sysMenuService;
    @Autowired
    MenuTreeUtil menuTreeUtil;

    @Logger("post模式登录")
    @PostMapping("/login")

    public String loginPost(String loginName, String password, String rememberMe) {
        System.out.println("post=====> loginName:" + loginName);
        ;
        System.out.println("post=====> password:" + password);
        ;
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(loginName);
        token.setPassword(password.toCharArray());
        if (!StringUtils.isEmpty(rememberMe)) {
            token.setRememberMe(true);
        }
        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            throw new GlobalException("登录失败，密码或账号不正确", e);
        }
//        sysMenuService.selectMenusById()
        return "redirect:/index";

    }

    @GetMapping("/index")
    @Logger("登录成功后转发到index")
    public ModelAndView index(HttpServletRequest request) {
        SysShiroUser shiroUser = ShiroUtils.getShiroUser();
        Long roleID = shiroUser.getRoleID();
        List<SysMenu> sysMenus = sysMenuService.selectMenusById(roleID);
        SysMenuItem item = menuTreeUtil.buildMenuTree(null, sysMenus);
        request.setAttribute("menus", item);
        return new ModelAndView("index.html");

    }


    @Logger(value = "Get模式登录")
    @GetMapping("/login")
    public ModelAndView loginGet(HttpServletRequest request) {
        SysShiroUser shiroUser = ShiroUtils.getShiroUser();
        if (shiroUser == null) {
            return new ModelAndView("login.html");
        }
        SysMenuItem item = menuTreeUtil.getMenuItem();
        if (item == null) {
            Long roleID = shiroUser.getRoleID();
            List<SysMenu> sysMenus = sysMenuService.selectMenusById(roleID);
            item = menuTreeUtil.buildMenuTree(null, sysMenus);
        }
        request.setAttribute("menus", item);
        return new ModelAndView("index.html");
    }

    @RequestMapping("/logout")
    @Logger("退出登录")
    public String logout() {
        SecurityUtils.getSubject().logout();
        menuTreeUtil.clearCache();
        System.out.println("2222");
        return "redirect:/login";
    }
}

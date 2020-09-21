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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    ISysMenuService sysMenuService;

    @Logger("post模式登录")
    @PostMapping("/login")
    public String loginPost(String loginName, String password, String rememberMe) {
        System.out.println("post=====> loginName:"+loginName);;
        System.out.println("post=====> password:"+password);;
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
        SysShiroUser shiroUser= ShiroUtils.getShiroUser();
        List<SysMenu> sysMenus = shiroUser.getMenus();
        SysMenuItem item = new SysMenuItem();
        SysMenu sysMenu = new SysMenu();
        item.setId(0L);
        item.setOrderNum(0);
        item.setName("顶级菜单");
        item.setSysMenu(sysMenu);
        request.setAttribute("menus",item);
        MenuTreeUtil.buildMenuTree(item,sysMenus);
//        System.out.println(ObjectMapperUtil.writeValueAsString(item));
        return  new ModelAndView("index.html");

    }


    @Logger(value = "Get模式登录")
    @GetMapping("/login")
    public ModelAndView loginGet() {
        System.out.println("进入login，get模式");
        return new ModelAndView("login.html");
    }
}

package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.annotation.Logger;
import com.zj.jingyuesystem.sys.entity.SysShiroUser;
import com.zj.jingyuesystem.sys.entity.SysUser;
import com.zj.jingyuesystem.sys.service.ISysUserService;
import com.zj.jingyuesystem.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping()
public class SysUserController extends BaseController {
//    @Reference(version = "1.0")
    @Autowired
    ISysUserService sysUserService;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "/system/user";

    @RequestMapping("/system/user")
    @Logger("进入system/user首页")
    public ModelAndView index() {
        SysShiroUser shiroUser = ShiroUtils.getShiroUser();

        return new ModelAndView(PREFIX + "/index.html");

    }

    @PostMapping("/system/user")
    @RequiresPermissions("system:user:view")
    @Logger("访问json" + PREFIX)
    @ResponseBody
    public JsonResult indexResult() {
        List<SysUser> userList = sysUserService.list();
        return JsonResult.success(userList);
    }


    @PostMapping(PREFIX + "/add")
    @RequiresPermissions("system:user:add")
    @ResponseBody
    public JsonResult add(SysUser sysUser) {
        sysUserService.save(sysUser);
        return JsonResult.success();
    }

    @PostMapping(PREFIX + "/update")
    @ResponseBody
    @RequiresPermissions(("system:user:edit"))
    public JsonResult update(SysUser sysUser) {

        sysUserService.update(sysUser, new UpdateWrapper<>(sysUser));
        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysUser  sysUser ){
       return JsonResult.success();
      }
    */


    @PostMapping(PREFIX + "/delete/{id}")
    @ResponseBody
    @RequiresPermissions("system:user:remove")
    public JsonResult deleteById(@PathVariable Integer id) {
        sysUserService.removeById(id);
        return JsonResult.success();
    }

    @PostMapping(PREFIX + "/select/{id}")
    @ResponseBody
    @RequiresPermissions("system:user:list")
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysUser> wrapper = queryWrapper.eq("id", id);
        SysUser one = sysUserService.getOne(wrapper);
        return JsonResult.success(one);
    }

    @PostMapping(PREFIX + "/import")
    @ResponseBody
    @Logger("导入文件开始……")
    @RequiresPermissions("system:user:import")
    public JsonResult importObject(MultipartFile multipartFile) {
        try {

            InputStream inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonResult.success();
    }

    @PostMapping(PREFIX + "/export")
    @RequiresPermissions("system:user:export")
    @ResponseBody
    @Logger("导出文件")
    public JsonResult exportFile(List<Integer> ids) {

        return JsonResult.success();
    }


}

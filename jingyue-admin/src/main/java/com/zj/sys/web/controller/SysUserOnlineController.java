package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.sys.entity.SysUserOnline;
import com.zj.jingyuesystem.sys.service.impl.SysUserOnlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 在线用户记录 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping("/sys/sysUserOnline")
public class SysUserOnlineController extends BaseController {

    @Autowired
    SysUserOnlineServiceImpl sysUserOnlineServiceImpl;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "sysUserOnline";

    @RequestMapping("/index")
    public ModelAndView index() {

        return new ModelAndView(PREFIX + "/index.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(SysUserOnline sysUserOnline) {

        return JsonResult.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(SysUserOnline sysUserOnline) {

        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysUserOnline  sysUserOnline ){
       return JsonResult.success();
      }
    */


    @PostMapping("/delete/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable Integer id) {
        sysUserOnlineServiceImpl.removeById(id);
        return JsonResult.success();
    }

    @PostMapping("/select/{id}")
    @ResponseBody
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysUserOnline> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysUserOnline> wrapper = queryWrapper.eq("id", id);
        List<SysUserOnline> list = sysUserOnlineServiceImpl.list(wrapper);

        return JsonResult.success(list);
    }


}

package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.sys.entity.SysPost;
import com.zj.jingyuesystem.sys.service.impl.SysPostServiceImpl;
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
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping("/sys/sysPost")
public class SysPostController extends BaseController {

    @Autowired
    SysPostServiceImpl sysPostServiceImpl;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "sysPost";

    @RequestMapping("/index")
    public ModelAndView index() {

        return new ModelAndView(PREFIX + "/index.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(SysPost sysPost) {

        return JsonResult.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(SysPost sysPost) {

        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysPost  sysPost ){
       return JsonResult.success();
      }
    */


    @PostMapping("/delete/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable Integer id) {
        sysPostServiceImpl.removeById(id);
        return JsonResult.success();
    }

    @PostMapping("/select/{id}")
    @ResponseBody
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysPost> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysPost> wrapper = queryWrapper.eq("id", id);
        List<SysPost> list = sysPostServiceImpl.list(wrapper);

        return JsonResult.success(list);
    }


}

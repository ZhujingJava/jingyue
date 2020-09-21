package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.sys.entity.SysConfig;
import com.zj.jingyuesystem.sys.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping("/sys/sysConfig")
public class SysConfigController extends BaseController {

    @Qualifier("iSysConfigService")
    private ISysConfigService iSysConfigService;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "sysConfig";

    @RequestMapping("/index")
    public ModelAndView index() {

        return new ModelAndView(PREFIX + "/index.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(SysConfig sysConfig) {

        return JsonResult.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(SysConfig sysConfig) {

        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysConfig  sysConfig ){
       return JsonResult.success();
      }
    */


    @PostMapping("/delete/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable Integer id) {
        iSysConfigService.removeById(id);
        return JsonResult.success();
    }

    @PostMapping("/select/{id}")
    @ResponseBody
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysConfig> wrapper = queryWrapper.eq("id", id);
        List<SysConfig> list = iSysConfigService.list(wrapper);

        return JsonResult.success(list);
    }


}

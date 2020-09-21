package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.sys.entity.SysDictData;
import com.zj.jingyuesystem.sys.service.impl.SysDictDataServiceImpl;
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
 * 字典数据表 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping("/sys/sysDictData")
public class SysDictDataController extends BaseController {

    @Autowired
    SysDictDataServiceImpl sysDictDataServiceImpl;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "sysDictData";

    @RequestMapping("/index")
    public ModelAndView index() {

        return new ModelAndView(PREFIX + "/index.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(SysDictData sysDictData) {

        return JsonResult.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(SysDictData sysDictData) {

        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysDictData  sysDictData ){
       return JsonResult.success();
      }
    */


    @PostMapping("/delete/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable Integer id) {
        sysDictDataServiceImpl.removeById(id);
        return JsonResult.success();
    }

    @PostMapping("/select/{id}")
    @ResponseBody
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysDictData> wrapper = queryWrapper.eq("id", id);
        List<SysDictData> list = sysDictDataServiceImpl.list(wrapper);

        return JsonResult.success(list);
    }


}

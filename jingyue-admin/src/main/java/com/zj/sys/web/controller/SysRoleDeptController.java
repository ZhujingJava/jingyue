package com.zj.sys.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.base.BaseController;
import com.zj.jingyuecommon.util.JsonResult;
import com.zj.jingyuesystem.sys.entity.SysRoleDept;
import com.zj.jingyuesystem.sys.service.impl.SysRoleDeptServiceImpl;
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
 * 角色和部门关联表 前端控制器
 * </p>
 *
 * @author zhujing
 * @since 2020-09-07
 */
@Controller
@RequestMapping("/sys/sysRoleDept")
public class SysRoleDeptController extends BaseController {

    @Autowired
    SysRoleDeptServiceImpl sysRoleDeptServiceImpl;
    /*非rest模式为以下代码*/
    private static final String PREFIX = "sysRoleDept";

    @RequestMapping("/index")
    public ModelAndView index() {

        return new ModelAndView(PREFIX + "/index.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(SysRoleDept sysRoleDept) {

        return JsonResult.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(SysRoleDept sysRoleDept) {

        return JsonResult.success();
    }
/*
     @PostMapping("/delete")
      @ResponseBody
      public JsonResult delete(SysRoleDept  sysRoleDept ){
       return JsonResult.success();
      }
    */


    @PostMapping("/delete/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable Integer id) {
        sysRoleDeptServiceImpl.removeById(id);
        return JsonResult.success();
    }

    @PostMapping("/select/{id}")
    @ResponseBody
    public JsonResult selectById(@PathVariable Integer id) {
        QueryWrapper<SysRoleDept> queryWrapper = new QueryWrapper<>();
        QueryWrapper<SysRoleDept> wrapper = queryWrapper.eq("id", id);
        List<SysRoleDept> list = sysRoleDeptServiceImpl.list(wrapper);

        return JsonResult.success(list);
    }


}

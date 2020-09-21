package com.zj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
@GetMapping("/")
    public String index(){
    System.out.println("进入indexcontroller");
    return   "login.html";
}
/*@ResponseBody
//    @GetMapping("/")
    public String index1(){
        System.out.println("进入indexcontroller");
        return     "hello,world";
  }*/

}

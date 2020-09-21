package com.zj.dubboconsumer.controller;

import com.zj.dubbo.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboRestController {
    @Reference(version = "1.0")
    private DubboService dubboService;

    @RequestMapping("/")
    public String  ins(){
        dubboService.ins();
        return "ins";
    }
}

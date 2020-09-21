package com.zj;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zj.jingyuesystem.sys.entity.SysUser;
import com.zj.jingyuesystem.sys.service.impl.SysUserServiceImpl;
import com.zj.jingyuesystem.utils.ObjectMapperUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class JingyueAdminApplicationTests {
    @Autowired
    SysUserServiceImpl sysUserService;


    @Test
    void contextLoads() {
        QueryWrapper<SysUser> queryWrapper= (QueryWrapper<SysUser>) new QueryWrapper().eq("user_id",1);
        SysUser one = sysUserService.getOne(queryWrapper);
        System.out.println(ObjectMapperUtil.writeValueAsString(one));

    }
    @Test
    void testLogin(){
        String name="admin";
        String password="admin";
        UsernamePasswordToken token=new UsernamePasswordToken();
        token.setUsername(name);
        token.setPassword(password.toCharArray());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

}

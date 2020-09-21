package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.zj.jingyuesystem.sys.mapper")
public class JingyueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JingyueAdminApplication.class, args);
    }

}

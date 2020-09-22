package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
@MapperScan("com.zj.jingyuesystem.sys.mapper")
public class JingyueAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JingyueAdminApplication.class, args);
    }

}

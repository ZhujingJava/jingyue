package com.zj.jingyuesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zj.jingyuesystem.sys.mapper")
public class JingyueServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JingyueServiceApplication.class);
    }
}

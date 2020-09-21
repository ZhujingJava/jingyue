package com.zj.jingyuesystem.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zj.jingyuesystem.base.DruidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = DruidProperties.class)
public class DataSourceConfig {
    @Autowired
    private DruidProperties druidProperties;

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(druidProperties.getUrl());
        druidDataSource.setDriverClassName(druidDataSource.getDriverClassName());
        druidDataSource.setPassword(druidProperties.getPassword());
        druidDataSource.setUsername(druidProperties.getName());
        druidDataSource.setMaxWait(10000);
        druidDataSource.setConnectionErrorRetryAttempts(10);
        System.out.println(druidProperties.getName()+":"+druidProperties.getPassword());
        return druidDataSource;
    }

}

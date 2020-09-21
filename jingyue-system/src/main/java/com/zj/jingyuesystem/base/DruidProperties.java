package com.zj.jingyuesystem.base;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.druid")
@Data
public class DruidProperties {
    private String url;
    private String name;
    private String password;
    private String driverClass;
    private int maxActive=8;

}

package com.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("project")
public class ProjectConfig {

    private String datafomate;

    public String getDatafomate() {
        return datafomate;
    }

    public void setDatafomate(String datafomate) {
        this.datafomate = datafomate;
    }
}

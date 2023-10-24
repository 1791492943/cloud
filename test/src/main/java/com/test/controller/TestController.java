package com.test.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.test.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProjectConfig config;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/haha")
    public String haha(){
        return "haha";
    }

    @GetMapping
    public String login(){
        return "当前会话登陆状态 " + StpUtil.isLogin() + "登陆人 " + StpUtil.getLoginId();
    }

    @GetMapping("/date")
    public String date(){
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern(config.getDatafomate()));
        return format;
    }

}

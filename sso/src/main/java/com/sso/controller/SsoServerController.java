package com.sso.controller;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.sso.SaSsoProcessor;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.feign.domain.entity.User;
import com.sso.mapper.LoginMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SsoServerController {

    @Resource
    private LoginMapper loginMapper;

    /*
     * SSO-Server端：处理所有SSO相关请求 (下面的章节我们会详细列出开放的接口)
     */
    @RequestMapping("/sso/*")
    public Object ssoRequest() {
        return SaSsoProcessor.instance.serverDister();
    }

    @RequestMapping("/login")
    public String login(String name, String pwd){
        System.out.println(name + pwd);
        User user = loginMapper.login(name, pwd);
        if(user != null){
            System.out.println(user);
        }
        return "登录成功";
    }

    /**
     * 配置SSO相关参数
     */
    @Autowired
    private void configSso(SaSsoConfig sso) {
        // 配置：未登录时返回的View
        sso.setNotLoginView(() -> {
            String msg = "当前会话在SSO-Server端尚未登录，请先访问"
                    + "<a href='/sso/doLogin?name=sa&pwd=123456' target='_blank'> doLogin登录 </a>"
                    + "进行登录之后，刷新页面开始授权";
            return msg;
        });

        // 配置：登录处理函数
        sso.setDoLoginHandle((name, pwd) -> {
            User user = loginMapper.login(name, pwd);
            if(user != null){
                StpUtil.login(user.getUserId());
                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
            }
            return SaResult.error("登录失败！");
        });

    }

}

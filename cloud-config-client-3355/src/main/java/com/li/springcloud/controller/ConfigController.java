package com.li.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: @RefreshScope 实现热加载 自动获取刷新内容 但是需要手动去发送请求到3355 来刷新注解
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/27 17:09
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort:" + serverPort + "\t\n\n configInfo: " + configInfo;
    }


}

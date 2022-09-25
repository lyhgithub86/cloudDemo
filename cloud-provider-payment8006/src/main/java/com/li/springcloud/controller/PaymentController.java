package com.li.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/15 15:46
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**@Description: 测试是否能够链接zookeeper服务器，不写其他内容了
     * @param
     * @return 
     * @version v1.0
     * @author lixs
     * @date 2022/9/15 15:51
     */
    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){

        return "Springcloud with zookeeper: "+serverPort + UUID.randomUUID().toString();
    }
}

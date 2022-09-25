package com.li.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/15 18:01
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderzkController {

    // zookeeper服务中心的服务名称
    public static final String INVOKE_URL = "http://cloud-payment-service";


    @Resource
    private RestTemplate restTemplate;
/**@Description: 测试链接。是否成功   一个地址。
 * @param
 * @return
 * @version v1.0
 * @author lixs
 * @date 2022/9/15 18:04
 */
    @GetMapping(value = "/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }


}

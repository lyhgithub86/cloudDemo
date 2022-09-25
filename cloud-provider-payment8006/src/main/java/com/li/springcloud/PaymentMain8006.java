package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ConditionalOnBlockingDiscoveryEnabled;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/12 10:01
 */
@SpringBootApplication
@EnableDiscoveryClient
//该注解用于向consul 或者zookeeper 作为注册中心服务时注册服务
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}

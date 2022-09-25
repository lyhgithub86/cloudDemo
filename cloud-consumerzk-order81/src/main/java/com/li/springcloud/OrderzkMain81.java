package com.li.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/15 17:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderzkMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderzkMain81.class,args);
    }
}

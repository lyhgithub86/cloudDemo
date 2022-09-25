package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/25 9:56
 */
@SpringBootApplication
@EnableHystrix
@EnableFeignClients
public class OrderFeignHystrixMain81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain81.class,args);
    }
}

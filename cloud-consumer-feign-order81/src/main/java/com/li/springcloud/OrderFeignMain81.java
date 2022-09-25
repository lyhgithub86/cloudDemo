package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/17 16:34
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain81.class,args);
    }
}

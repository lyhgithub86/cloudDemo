package com.li.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/13 17:04
 */

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002.class,args);
    }
}

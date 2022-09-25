package com.li.springcloud;

import com.li.myrule.MySeleRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/12 15:56
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name ="CLOUD-PAYMENT-SERVICE", configuration = MySeleRule.class)
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}

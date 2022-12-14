package com.li.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/15 17:58
 */
@Configuration
public class ApplicationContextConfig{


    @Bean
    @LoadBalanced
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }
}

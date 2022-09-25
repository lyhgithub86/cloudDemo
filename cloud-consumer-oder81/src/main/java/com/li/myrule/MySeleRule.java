package com.li.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/16 16:34
 */
@Configuration
public class MySeleRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

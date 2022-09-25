package com.li.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 编码的方式用gateway 网关访问百度国外版
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/25 17:22
 */
@Configuration
public class GateWayConfig {

    /**@Description:    可以对照着yml里面内容编写下面的配置
                        gateway:
                            discovery:
                            locator:
                            enabled: true #开启从注册中心动态创建路由的功能，利用微服务名进行路由
                            routes:
                            - id: payment_routh #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
                            uri: http://localhost:8001          #匹配后提供服务的路由地址
                            #        uri: lb://cloud-payment-service #匹配后提供服务的路由地址
                            predicates:
                            - Path=/payment/get/**         # 断言，路径相匹配的进行路由
    #
     * @param
     * @return
     * @version v1.0
     * @author lixs
     * @date 2022/9/25 17:25
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_li", r -> r.path("/guoji").uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}

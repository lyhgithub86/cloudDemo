package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.lb.Loadbalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/12 15:58
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private Loadbalancer loadbalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/add")
    public CommonResult<Payment> add(Payment payment) {
        log.info(this.getClass().getName() + "add");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",
                payment,
                CommonResult.class);
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info(this.getClass().getName() + "get id->" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id
                , CommonResult.class);
    }


    /**@Description: 测试自定义负载均衡是否成功   现在 500 错误，  uri 错误。注册中心，uri 不能直接用端口号待解决  TODO
     * @param
     * @return
     * @version v1.0
     * @author lixs
     * @date 2022/9/17 9:22
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB(){

        List<ServiceInstance> instancesList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instancesList == null|| instancesList.size()<=0) {
            return null;
        }

        ServiceInstance serviceInstance = loadbalancer.instances(instancesList);

        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}

package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/12 11:14
 */

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

//    @Resource  名称注入   autowired 类型注入
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    //    服务发现
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);

        log.info("************插入结果********->"+result);
        if (result > 0) {
            return new CommonResult(200,"添加数据成功");
        }

        return new CommonResult(440,"添加数据失败",null);
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {

            log.info("***************查询成功—>"+ payment.toString());
            return new CommonResult(200,"  查询成功，serverPort：" + serverPort,payment);


        }

        return new CommonResult(441,"查询数据失败无对应ID数据 ,serverPort:"+serverPort+"ID"+ id ,null);

    }


    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });

        return this.discoveryClient;
    }
}

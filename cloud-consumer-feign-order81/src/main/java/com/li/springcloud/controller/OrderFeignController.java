package com.li.springcloud.controller;

import com.li.springcloud.entities.CommonResult;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/17 16:39
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){


        return  paymentFeignService.getPaymentById(id);
    }
}

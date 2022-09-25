package com.li.springcloud.service.impl;

import com.li.springcloud.service.PaymentHystrixService;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/25 10:03
 */
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }

}

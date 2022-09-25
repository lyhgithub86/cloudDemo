package com.li.springcloud.service.impl;

import com.li.springcloud.dao.PaymentDao;
import com.li.springcloud.entities.Payment;
import com.li.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/12 10:58
 */
@Service
public class PaymentServiceImpl implements PaymentService {

//    @Autowired
//    autowired 和 resource（java 自带的） 都可进行依赖注入
//          如果前面Dao(mapper) 里面用的是@mapper 的话可能 @Autowired无法注入
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

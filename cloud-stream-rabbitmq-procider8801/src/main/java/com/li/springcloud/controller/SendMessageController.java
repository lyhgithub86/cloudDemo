package com.li.springcloud.controller;

import com.li.springcloud.service.IMessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description: new java files header..
 *
 * @author lixs
 * @version 1.0
 * @date 2022/10/9 10:25
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProviderService messageProviderService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProviderService.send();
    }

}

package com.li.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * Description:
 *  @EnableBinding(Sink.class) 定义消息的推送管道 将Channel和Exchanges绑定在一起
 *                 Source 是生产者用的。Sink 是消费者端绑定
 * @author lixs
 * @version 1.0
 * @date 2022/10/9 10:36
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("port:" + serverPort + "\t接受：" + message.getPayload());
    }

}

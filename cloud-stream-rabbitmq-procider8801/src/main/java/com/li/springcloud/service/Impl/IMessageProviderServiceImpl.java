package com.li.springcloud.service.Impl;

import com.li.springcloud.service.IMessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Description: new java files header..
 * @EnableBinding(Source.class) 定义消息的推送管道 将Channel和Exchanges绑定在一起
 *                Source 是生产者用的。Sink 是消费者端绑定的
 * @author lixs
 * @version 1.0
 * @date 2022/10/9 10:27
 */
@EnableBinding(Source.class)
public class IMessageProviderServiceImpl implements IMessageProviderService {

    @Resource
    private MessageChannel output;
/**@Description: 消息发送信道。
 * @param
 * @return
 * @version v1.0
 * @author lixs
 * @date 2022/10/9 10:29
 */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> stringMessage = MessageBuilder.withPayload(serial).build();
        output.send(stringMessage);

        System.out.println("*****serial: " + serial);
        return serial;
    }
}

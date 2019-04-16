package com.kither.provider;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息提供者
 */
@Component("rabbitProvider")
public class RabbitProvider {

    // 消息队列模板对象
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 此处使用的是一对一的转换器，必须routingKey一直才能正确接收到消息
    public void sendMessage(Object object) {
        // 第一个参数为发送队列的名称，第二个参数为发送消息内容
        String json = new Gson().toJson(object);
        rabbitTemplate.convertAndSend("sendDirect", json);
        System.out.println("消息提供者发送消息");
    }
}

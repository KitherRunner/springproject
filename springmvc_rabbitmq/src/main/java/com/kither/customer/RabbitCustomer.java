package com.kither.customer;

import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component("rabbitCustomer")
public class RabbitCustomer {

    public void customeMessage(String message) {

        System.out.println("message: " + message);

        System.out.println("消费消息： " + message);
    }
}

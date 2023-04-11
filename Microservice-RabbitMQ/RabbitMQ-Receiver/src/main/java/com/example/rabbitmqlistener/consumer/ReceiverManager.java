package com.example.rabbitmqlistener.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverManager {
    @RabbitListener(queues = "Rino-queue")
    void listener(String msg) {
        System.out.println(msg);
    }

    @RabbitListener(queues = "Product-Queue")
    void listenerQ(String msg) {
        System.out.println(msg);
    }
}

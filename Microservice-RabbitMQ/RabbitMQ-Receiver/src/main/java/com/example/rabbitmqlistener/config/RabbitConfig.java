package com.example.rabbitmqlistener.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String queueName = "Rino-queue";

    public static final String exchangeName = "Exchange-Listener";
}

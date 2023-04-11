package com.example.rabbitmqsender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitMqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqSenderApplication.class, args);
    }

}

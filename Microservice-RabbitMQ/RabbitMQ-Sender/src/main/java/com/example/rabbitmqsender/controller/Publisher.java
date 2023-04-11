package com.example.rabbitmqsender.controller;

import com.example.rabbitmqsender.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rabbit-mq/")
public class Publisher {

    @Autowired
    RabbitTemplate template;

    @PostMapping("send")
    public ResponseEntity<?> send(@RequestBody String message) {
        template.setExchange(RabbitConfig.exchange);
        template.convertAndSend(message);
        return ResponseEntity.ok(message);
    }
}

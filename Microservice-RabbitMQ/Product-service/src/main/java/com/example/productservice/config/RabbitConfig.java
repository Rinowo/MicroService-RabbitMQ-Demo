package com.example.productservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("$rabbitmq.queue.name")
    public static String queueName;

    @Value("$rabbitmq.exchange.name")
    public static String exchange;

    @Bean
    Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}

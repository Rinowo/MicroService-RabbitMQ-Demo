package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
//        http://localhost:8080/product/api/product/save
                .route("PRODUCT-SERVICE",r -> r.path("/product/**")
                        .filters(f -> f.rewritePath("/product/(?<remains>.*)", "/${remains}"))
                        .uri("lb://PRODUCT-SERVICE/"))
//                .route("pay-service",r -> r.path("/rabbit-mq/")
//                        .filters(f -> f.rewritePath("/rabbit-mq/(?<remains>.*)", "/${remains}"))
//                        .uri("lb://SENDER-SERVICE/"))
//                .route("inventory-service",r -> r.path("/rabbit-mq/**")
//                        .filters(f -> f.rewritePath("/rabbit-mq/(?<remains>.*)", "/${remains}"))
//                        .uri("lb://RECEIVER-SERVICE/"))
                .build();
//
    }
}

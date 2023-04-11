package com.example.productservice.controller;

import com.example.productservice.config.RabbitConfig;
import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/product/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private RabbitTemplate template;

    @GetMapping("{id}")
    public ResponseEntity<?> findid(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
        template.setExchange(RabbitConfig.exchange);
        template.convertAndSend(productDto);
        return new ResponseEntity<>(productService.save(productDto),HttpStatus.OK);
    }
}

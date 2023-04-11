package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;

import java.util.Map;

public interface ProductService {

    Boolean save(ProductDto productDto);

    Map<String, Object> findById(Long id);
}

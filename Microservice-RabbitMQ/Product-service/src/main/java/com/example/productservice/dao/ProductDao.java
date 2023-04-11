package com.example.productservice.dao;

import com.example.productservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean save(ProductDto productDTO) {
        String query = "INSERT INTO product(name, price, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(query,
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity());
        return true;
    }

    public List<ProductDto> findOne(Long id) {
        String query = "SELECT id, name, price, quantity FROM product WHERE id = " + id;
        return  jdbcTemplate.query(query,new BeanPropertyRowMapper<>(ProductDto.class));
    }


}

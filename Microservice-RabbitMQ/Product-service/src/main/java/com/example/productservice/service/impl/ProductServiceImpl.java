package com.example.productservice.service.impl;

import com.example.productservice.dao.ProductDao;
import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDAO;

    @Override
    public Boolean save(ProductDto productDto){
        return productDAO.save(productDto);
    }

    @Override
    public Map<String, Object> findById(Long id) {
        List<ProductDto> listContentPage = productDAO.findOne(id);

        Map<String, Object> responses = new HashMap<>();
        responses.put("content", listContentPage);
//        responses.put("currentPage", listContentPage.getPage());
        responses.put("totalItems", listContentPage.size());
//        responses.put("totalPage", (int) Math.ceil((double) listContentNoPage.size() / blogSearchBody.getLimit()));
        return responses;
    }
}

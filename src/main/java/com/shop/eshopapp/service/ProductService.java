package com.shop.eshopapp.service;

import com.shop.eshopapp.enums.Category;
import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    Optional<Product> save(String name, Category category, int price,String description);
    Optional<Product> edit(Long id, String name, Category category,int price, String description) throws ProductNotFoundException;
    void deleteById(Long id);
}

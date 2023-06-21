package com.shop.eshopapp.service.impl;

import com.shop.eshopapp.enums.Category;
import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.exceptions.ProductNotFoundException;
import com.shop.eshopapp.repository.ProductRepository;
import com.shop.eshopapp.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(String name, Category category, int price, String description) {
        this.productRepository.deleteByName(name);
        Product product=new Product(name,category,price,description);
        this.productRepository.save(product);
        return Optional.of(product);
    }

    @Override
    public Optional<Product> edit(Long id, String name, Category category, int price, String description) throws ProductNotFoundException {
        Product product=this.productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setDescription(description);

        this.productRepository.save(product);

        return Optional.of(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}

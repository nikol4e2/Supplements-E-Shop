package com.shop.eshopapp.service;

import com.shop.eshopapp.model.Order;
import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();
    Optional<Order> findById(Long id);
    Optional<Order> save(User user, String address, List<Product> products);
}

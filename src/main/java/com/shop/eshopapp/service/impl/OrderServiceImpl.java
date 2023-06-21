package com.shop.eshopapp.service.impl;

import com.shop.eshopapp.model.Order;
import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.User;
import com.shop.eshopapp.repository.OrderRepository;
import com.shop.eshopapp.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Optional<Order> save(User user, String address,List<Product> products) {
        return Optional.of(this.orderRepository.save(new Order(user,address,products)));
    }
}

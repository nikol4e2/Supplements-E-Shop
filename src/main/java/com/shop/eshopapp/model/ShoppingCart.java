package com.shop.eshopapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;

    public ShoppingCart() {
        this.products=new ArrayList<>();
    }

    public ShoppingCart(User user) {
        this.user = user;
        this.products=new ArrayList<>();
    }
}

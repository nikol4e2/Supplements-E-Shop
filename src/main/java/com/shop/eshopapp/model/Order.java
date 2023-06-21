package com.shop.eshopapp.model;

import com.shop.eshopapp.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Product> products;
    private OrderStatus status;

    @ManyToOne
    private User user;

    private String address;

    private int totalPrice;

    public Order( User user, String address,List<Product> products) {
        this.products = products;
        this.status = OrderStatus.PROCESSING;
        this.user = user;
        this.address = address;
        calculateTotalPrice();

    }

    public Order() {
    }

    private void calculateTotalPrice()
    {
        this.totalPrice=0;
        for(int i=0;i<products.size();i++)
        {
            this.totalPrice+=products.get(i).getPrice();
        }
    }
}

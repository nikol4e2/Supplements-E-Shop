package com.shop.eshopapp.model;

import com.shop.eshopapp.enums.Category;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product  {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Category category;
    private int price;
    private String description;

    public Product(String name, Category  category, int price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Product() {

    }
}

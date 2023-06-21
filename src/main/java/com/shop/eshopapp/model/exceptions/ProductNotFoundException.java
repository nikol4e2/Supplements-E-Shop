package com.shop.eshopapp.model.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Long id) {
        super(String.format("Product with the id %d doesnt exist",id));
    }
}

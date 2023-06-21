package com.shop.eshopapp.model.exceptions;

public class ShoppingCartNotFoundException extends Exception{

    public ShoppingCartNotFoundException(Long id) {
        super(String.format("Shopping cart with id %d is not found",id));
    }
}

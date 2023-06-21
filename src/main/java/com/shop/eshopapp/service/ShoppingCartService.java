package com.shop.eshopapp.service;

import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.ShoppingCart;
import com.shop.eshopapp.model.exceptions.ProductNotFoundException;
import com.shop.eshopapp.model.exceptions.ShoppingCartNotFoundException;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    ShoppingCart save();
    Optional<ShoppingCart> findById(Long id);
    ShoppingCart addProductToShoppingCart(String username, Long productId) throws ProductNotFoundException;
    List<Product> listAllProductsInShoppingCart(Long cartId) throws ShoppingCartNotFoundException;
    ShoppingCart getActiveShoppingCart(String username);
}

package com.shop.eshopapp.service.impl;

import com.shop.eshopapp.model.Product;
import com.shop.eshopapp.model.ShoppingCart;
import com.shop.eshopapp.model.User;
import com.shop.eshopapp.model.exceptions.ProductNotFoundException;
import com.shop.eshopapp.model.exceptions.ShoppingCartNotFoundException;
import com.shop.eshopapp.repository.ShoppingCartRepository;
import com.shop.eshopapp.repository.UserRepository;
import com.shop.eshopapp.service.ProductService;
import com.shop.eshopapp.service.ShoppingCartService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;


    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public ShoppingCart save() {
        return this.shoppingCartRepository.save(new ShoppingCart());
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user=this.userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));

        return this.shoppingCartRepository
                .findByUser(user).orElseGet(()->{ShoppingCart cart=new ShoppingCart(user);
                        return this.shoppingCartRepository.save(cart);});
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) throws ProductNotFoundException {
        ShoppingCart shoppingCart=this.getActiveShoppingCart(username);
        Product product=this.productService.findById(productId).orElseThrow(()->new ProductNotFoundException(productId));

        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) throws ShoppingCartNotFoundException {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();

    }
}

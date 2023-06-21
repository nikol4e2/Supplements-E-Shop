package com.shop.eshopapp.repository;

import com.shop.eshopapp.model.ShoppingCart;
import com.shop.eshopapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository  extends JpaRepository<ShoppingCart,Long> {

    Optional<ShoppingCart> findByUser(User user);

}

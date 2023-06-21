package com.shop.eshopapp.repository;

import com.shop.eshopapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username,String password);

}

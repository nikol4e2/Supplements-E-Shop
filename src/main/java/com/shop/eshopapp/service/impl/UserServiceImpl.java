package com.shop.eshopapp.service.impl;

import com.shop.eshopapp.enums.Role;
import com.shop.eshopapp.model.User;
import com.shop.eshopapp.repository.UserRepository;
import com.shop.eshopapp.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String name, String surname, String email, String password, String repeatPassword, String phoneNumber, Role role) {
        return this.userRepository.save(new User(username,name,surname,email,password,phoneNumber,Role.ROLE_USER));
    }
}

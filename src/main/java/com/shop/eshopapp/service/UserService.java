package com.shop.eshopapp.service;

import com.shop.eshopapp.enums.Role;
import com.shop.eshopapp.model.User;

public interface UserService {

    User register(String username, String name, String surname, String email, String password,String repeatPassword, String phoneNumber, Role role);
}

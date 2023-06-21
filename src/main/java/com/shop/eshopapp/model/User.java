package com.shop.eshopapp.model;


import com.shop.eshopapp.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private long Id;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User( String username, String name, String surname, String email, String password, String phoneNumber, Role role)
    {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}

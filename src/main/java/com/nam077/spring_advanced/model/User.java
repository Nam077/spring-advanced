package com.nam077.spring_advanced.model;

import jakarta.persistence.Column;

public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;
}

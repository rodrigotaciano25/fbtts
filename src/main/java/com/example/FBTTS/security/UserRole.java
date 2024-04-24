package com.example.FBTTS.security;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("user");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

}

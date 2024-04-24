package com.example.FBTTS.security;

public record RegisterDTO(String email, String password, UserRole role) {
}

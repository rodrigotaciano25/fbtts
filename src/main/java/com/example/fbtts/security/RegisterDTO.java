package com.example.fbtts.security;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}
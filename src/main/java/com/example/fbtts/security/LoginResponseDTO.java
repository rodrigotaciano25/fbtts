package com.example.fbtts.security;

import com.example.fbtts.entity.User;

public record LoginResponseDTO(String token, String email, String username) {
    public static LoginResponseDTO fromUserAndToken(User user, String token) {
        return new LoginResponseDTO(token, user.getEmail(), user.getUsername());
    }
}

package com.example.fbtts.service.security;

import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.entity.User;

public class UserService {
    private UserRepository userRepository;
    //private PasswordEncoder passwordEncoder;
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User saveUser(User user) {
        // Encode password before saving
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Use password encoder to check if the provided password matches the encoded password in the database
            return true;//passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}

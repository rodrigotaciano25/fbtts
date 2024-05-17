package com.example.fbtts.service.security;

import com.example.fbtts.entity.Method;
import com.example.fbtts.entity.User;
import com.example.fbtts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired // This annotation ensures UserRepository is injected
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
        // Use password encoder to check if the provided password matches the encoded password in the database
        return user != null;//passwordEncoder.matches(password, user.getPassword());
    }

    public void addMethodToUser(String userEmail, Method method) {
        User user = userRepository.findByEmail(userEmail);
        if (user != null) {
            method.setUser(user.getEmail()); // Set the user email for the method
            user.getMethods().add(method);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

}

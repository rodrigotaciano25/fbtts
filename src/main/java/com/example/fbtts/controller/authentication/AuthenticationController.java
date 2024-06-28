package com.example.fbtts.controller.authentication;

import com.example.fbtts.infra.security.TokenService;
import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.security.AuthenticationDTO;
import com.example.fbtts.security.LoginResponseDTO;
import com.example.fbtts.security.RegisterDTO;
import com.example.fbtts.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        try {
            System.out.println("Email: " + data.email() + ", Password: " + data.password());

            User user = userRepository.findByEmail(data.email());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
            }

            if (!passwordEncoder.matches(data.password(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
            }

            var token = tokenService.generateToken(user);

            return ResponseEntity.ok(LoginResponseDTO.fromUserAndToken(user, token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed.");
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body("User with this email already exists.");
        }

        // Assuming username is required and not nullable
        if (data.username() == null || data.username().isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be empty.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }


}

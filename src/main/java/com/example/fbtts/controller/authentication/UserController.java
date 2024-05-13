package com.example.fbtts.controller.authentication;

import com.example.fbtts.entity.Method;
import com.example.fbtts.entity.User;
import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.service.MethodService;
import com.example.fbtts.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController with improved security considerations and error handling.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MethodService methodService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a list of methods associated with a specific user (if authorized).
     * Requires appropriate authorization mechanisms.
     *
     * @param email The email address of the user to retrieve methods for.
     * @return A ResponseEntity containing the list of methods (200 OK) or an appropriate error response.
     */
    @GetMapping("/users/{email}/methods")
    public ResponseEntity<List<Method>> getMethodsByUserEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<Method> methods = methodService.getAllByUser(email);
        return ResponseEntity.ok(methods);
    }

    @PostMapping("/users/{userEmail}/methods")
    public ResponseEntity<String> addMethodToUser(@PathVariable String userEmail, @RequestBody Method method) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated.");
        }

        String currentUserEmail = authentication.getName();
        // Check if the authenticated user email matches the provided userEmail
        if (!currentUserEmail.equals(userEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }

        try {
            userService.addMethodToUser(userEmail, method);
            return ResponseEntity.ok("Method added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding method to user.");
        }
    }

}

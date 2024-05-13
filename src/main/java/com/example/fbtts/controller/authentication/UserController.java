package com.example.fbtts.controller.authentication;

import com.example.fbtts.entity.Method;
import com.example.fbtts.entity.User;
import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


 /**
 * UserController with improved security considerations and error handling.
 */
@RestController
public class UserController {
    @Autowired
    private MethodService methodService;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{email}/methods")
    public ResponseEntity<List<Method>> getMethodsByUserEmail(@PathVariable String email) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<Method> methods = methodService.getAllByUser(email);
        return ResponseEntity.ok(methods);
    }

}

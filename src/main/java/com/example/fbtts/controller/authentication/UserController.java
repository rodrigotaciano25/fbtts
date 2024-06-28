package com.example.fbtts.controller.authentication;

import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/{email}/cliques")
    public ResponseEntity<Integer> getUserCliques(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user.getClicks());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{email}/decrement-clicks")
    public ResponseEntity<?> decrementUserClicks(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getClicks() > 0) {
                user.setClicks(user.getClicks() - 1);
                userRepository.save(user);
                return ResponseEntity.ok(user.getClicks());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No more clicks left");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}

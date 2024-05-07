package com.example.fbtts.controller;

import com.example.fbtts.entity.Method;
import com.example.fbtts.service.MethodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/methods")
@AllArgsConstructor
public class MethodController {
    private MethodService methodService;

    @GetMapping("/{id}")
    public ResponseEntity<Method> findById(@PathVariable long id) {
        System.out.println(id);
        Method method = methodService.findById(id);
        if (method != null) {
            return ResponseEntity.ok(method);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{title}/{user}")
    public ResponseEntity<Method> findByTitleAndUser(@PathVariable String title, @PathVariable String user) {
        System.out.println(title);
        System.out.println(user);
        Method method = methodService.findByTitleAndUser(title, user);
        if (method != null) {
            return ResponseEntity.ok(method);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

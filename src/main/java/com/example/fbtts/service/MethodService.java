package com.example.fbtts.service;

import com.example.fbtts.entity.Method;
import com.example.fbtts.repository.MethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MethodService {
    private final MethodRepository methodRepository;

    public Method findById(long id) {
        System.out.println("Searching for method with id: " + id);
        Method method = methodRepository.findById(id);
        System.out.println("Found team: " + method);
        return method;
    }

    public Method findByTitleAndUser(String title, String user) {
        System.out.println("Searching method with the title " + title + "and user: " + user);
        Method method = methodRepository.findByTitleAndUser(title, user);
        System.out.println("Found method: " + method);
        return method;
    }

}

package com.example.fbtts.service;

import com.example.fbtts.entity.Method;
import com.example.fbtts.repository.MethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MethodService {
    @Autowired
    private MethodRepository methodRepository;

    public Method findById(long id) {
        return methodRepository.findById(id);
    }

    public Method findByTitleAndUser(String title, String user) {
        return methodRepository.findByTitleAndUser(title, user);
    }

    public List<Method> getAllByUser(String user) {
        return methodRepository.findAllByUser(user);
    }

    public Method findByUser(String user) {
        return methodRepository.findByUser(user);
    }

    public Method addMethod(Method method) {
        return methodRepository.save(method);
    }
}

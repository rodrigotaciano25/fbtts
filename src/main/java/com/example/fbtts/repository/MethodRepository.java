package com.example.fbtts.repository;

import com.example.fbtts.entity.Method;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MethodRepository extends MongoRepository<Method, Long> {
    public Method findById(long id);

    Method findByTitleAndUser(String title, String user);

    List<Method> findAllByUser(String email);

    public Method findByUser(String user);

    public Method save(Method method);
}

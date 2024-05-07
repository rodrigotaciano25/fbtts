package com.example.fbtts.repository;

import com.example.fbtts.entity.Method;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MethodRepository extends MongoRepository<Method, Long> {
    public Method findById(long id);

    public Method findByTitleAndUser(String title, String user);
}

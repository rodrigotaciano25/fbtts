package com.example.FBTTS.repositories;

import com.example.FBTTS.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}

package com.example.fbtts.repository;

import com.example.fbtts.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
    public Team findByName(String name);
}

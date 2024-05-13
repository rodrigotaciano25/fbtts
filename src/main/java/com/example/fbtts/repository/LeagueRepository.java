package com.example.fbtts.repository;

import com.example.fbtts.entity.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, Long> {

    League findById(long id);
    League findByName(String name);

}

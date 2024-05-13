package com.example.fbtts.repository;

import com.example.fbtts.entity.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, Long> {

    public League findById(long id);
    public League findByName(String name);
    public League findByCountryId(long countryId);

}

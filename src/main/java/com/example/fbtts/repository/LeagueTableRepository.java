package com.example.fbtts.repository;

import com.example.fbtts.entity.LeagueTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueTableRepository extends MongoRepository<LeagueTable, String> {
    public LeagueTable findByName(String name);
}

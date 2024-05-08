package com.example.fbtts.repository;

import com.example.fbtts.entity.Market;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketRepository extends MongoRepository<Market, Integer> {
    public Market findById(int id);
}

package com.example.fbtts.repository;

import com.example.fbtts.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, Long> {
    public Country findById(long id);
}

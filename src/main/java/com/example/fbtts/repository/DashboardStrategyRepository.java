package com.example.fbtts.repository;

import com.example.fbtts.entity.DashboardStrategy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DashboardStrategyRepository extends MongoRepository<DashboardStrategy, String> {
    public DashboardStrategy findByTitleAndUser(String title, String user);
}

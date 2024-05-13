package com.example.fbtts.repository;

import com.example.fbtts.entity.MatchDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchDetailRepository extends MongoRepository<MatchDetail, Long> {
    MatchDetail findByMatchId(Long matchId);
}

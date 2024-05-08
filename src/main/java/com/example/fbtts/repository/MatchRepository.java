package com.example.fbtts.repository;

import com.example.fbtts.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, Long> {
    public Match findById(long id);

    public Match findByRoundAndHomeAndAway(String round, String home, String away);
}

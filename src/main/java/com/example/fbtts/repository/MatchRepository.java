package com.example.fbtts.repository;

import com.example.fbtts.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match, Long> {
    Match findById(long id);

    public Match findByRoundAndHomeAndAway(String round, String home, String away);

    public Match findByDateAndMatch(String date, String match);

    public List<Match> findAllByLeague(String league);

}


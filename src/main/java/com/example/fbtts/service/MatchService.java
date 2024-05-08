package com.example.fbtts.service;

import com.example.fbtts.entity.Match;
import com.example.fbtts.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;

    public Match findById(long id) {
        return matchRepository.findById(id);
    }

    public Match findByRoundAndHomeAndAway(String round, String home, String away) {
        return matchRepository.findByRoundAndHomeAndAway(round, home, away);
    }

}

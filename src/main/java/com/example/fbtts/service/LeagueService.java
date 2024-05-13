package com.example.fbtts.service;

import com.example.fbtts.entity.League;
import com.example.fbtts.repository.LeagueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LeagueService {
    private LeagueRepository leagueRepository;

    public League findById(long id) {
        return leagueRepository.findById(id);
    }

    public League findByName(String name) {
        return leagueRepository.findByName(name);
    }
}

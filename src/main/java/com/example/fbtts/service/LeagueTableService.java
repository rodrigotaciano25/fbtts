package com.example.fbtts.service;

import com.example.fbtts.entity.League;
import com.example.fbtts.entity.LeagueTable;
import com.example.fbtts.repository.LeagueTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LeagueTableService {
    private final LeagueTableRepository leagueTableRepository;

    public LeagueTable findByName(String name) {
        System.out.println("Searching for league with name: " + name);
        LeagueTable leagueTable = leagueTableRepository.findByName(name);
        System.out.println("Found league: " + leagueTable);
        return leagueTable;
    }
}

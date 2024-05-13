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
        System.out.println("Searching for league with id: " + id);
        League league = leagueRepository.findById(id);
        System.out.println("Found league: " + league);
        return league;
    }

    public League findByName(String name) {
        System.out.println("Searching for league with name: " + name);
        League league = leagueRepository.findByName(name);
        System.out.println("Found league: " + league);
        return league;
    }

    public League findByCountryId(long countryId) {
        System.out.println("Searching for league with countryId: " + countryId);
        League league = leagueRepository.findById(countryId);
        System.out.println("Found league: " + league);
        return league;
    }
}

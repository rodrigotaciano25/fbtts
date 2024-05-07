package com.example.fbtts.service;

import com.example.fbtts.entity.LeagueTableRow;
import com.example.fbtts.repository.LeagueTableRowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LeagueTableRowService {
    private final LeagueTableRowRepository leagueTableRowRepository;

    public LeagueTableRow findById(long teamId) {
        System.out.println("Searching for team with name: " + teamId);
        LeagueTableRow leagueTableRow = leagueTableRowRepository.findByTeamId(teamId);
        System.out.println("Found team: " + leagueTableRow);
        return leagueTableRow;
    }

    public LeagueTableRow findByTeam(String team) {
        System.out.println("Searching for league with name: " + team);
        LeagueTableRow leagueTableRow = leagueTableRowRepository.findByTeam(team);
        System.out.println("Found team: " + leagueTableRow);
        return leagueTableRow;
    }
}

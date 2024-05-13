package com.example.fbtts.controller;

import com.example.fbtts.entity.League;
import com.example.fbtts.entity.LeagueTableRow;
import com.example.fbtts.service.LeagueTableRowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leagueTableRows")
@AllArgsConstructor
public class LeagueTableRowController {
    private final LeagueTableRowService leagueTableRowService;

    @GetMapping("/{teamId}")
    public ResponseEntity<LeagueTableRow> findByTeamId(@PathVariable long teamId) {
        System.out.println(teamId);
        LeagueTableRow leagueTableRow = leagueTableRowService.findByTeamId(teamId);
        if (leagueTableRow != null) {
            return ResponseEntity.ok(leagueTableRow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{team}")
    public ResponseEntity<LeagueTableRow> findByTeam(@PathVariable String team) {
        System.out.println(team);
        LeagueTableRow leagueTableRow = leagueTableRowService.findByTeam(team);
        if (leagueTableRow != null) {
            return ResponseEntity.ok(leagueTableRow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

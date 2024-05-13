package com.example.fbtts.controller;

import com.example.fbtts.entity.League;
import com.example.fbtts.repository.LeagueRepository;
import com.example.fbtts.service.LeagueService;
import com.example.fbtts.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
@AllArgsConstructor
public class LeagueController {
    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    private LeagueService leagueService;

    @PostMapping("/saveLeague")
    public League save(@RequestBody League league) {
        // generate sequence
        league.setId((long) sequenceGeneratorService.getSequenceNumber(League.SEQUENCE_NAME));
        return leagueRepository.save(league);
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<League> findByName(@PathVariable String name) {
        System.out.println(name);
        League league = leagueService.findByName(name);
        if (league != null) {
            return ResponseEntity.ok(league);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


package com.example.fbtts.controller;

import com.example.fbtts.entity.League;
import com.example.fbtts.service.LeagueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leagues") // Define a base mapping for all endpoints in this controller
@AllArgsConstructor
public class LeagueController {
    private LeagueService leagueService;

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

    @GetMapping("/{id}")
    public ResponseEntity<League> findById(@PathVariable long id) {
        System.out.println(id);
        League league = leagueService.findById(id);
        if (league != null) {
            return ResponseEntity.ok(league);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


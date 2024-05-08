package com.example.fbtts.controller;

import com.example.fbtts.entity.Team;
import com.example.fbtts.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/{name}")
    public ResponseEntity<Team> findByName(@PathVariable String name) {
        System.out.println(name);
        Team team = teamService.findByName(name);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

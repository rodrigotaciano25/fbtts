package com.example.fbtts.controller;

import com.example.fbtts.entity.LeagueTable;
import com.example.fbtts.service.LeagueTableService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leaguetables")
@AllArgsConstructor
public class LeagueTableController {
    private LeagueTableService leagueTableService;

    @GetMapping("/{name}")
    public ResponseEntity<LeagueTable> findByName(@PathVariable String name) {
        System.out.println(name);
        LeagueTable leagueTable = leagueTableService.findByName(name);
        if (leagueTable != null) {
            return ResponseEntity.ok(leagueTable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.fbtts.controller;

import com.example.fbtts.entity.Match;
import com.example.fbtts.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matches")
@AllArgsConstructor
public class MatchController {
    private MatchService matchService;

    @GetMapping("/{id}")
    public ResponseEntity<Match> findById(@PathVariable long id) {
        System.out.println(id);
        Match match = matchService.findById(id);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{round}/{home}/{away}")
    public ResponseEntity<Match> findByRoundAndHomeAndAway(@PathVariable String round, @PathVariable String home, @PathVariable String away) {
        System.out.println(round);
        System.out.println(home);
        System.out.println(away);
        Match match = matchService.findByRoundAndHomeAndAway(round, home, away);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package com.example.fbtts.controller;

import com.example.fbtts.entity.Match;
import com.example.fbtts.repository.MatchRepository;
import com.example.fbtts.service.MatchService;
import com.example.fbtts.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@AllArgsConstructor
public class MatchController {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private MatchRepository matchRepository;

    private MatchService matchService;

    @PostMapping("/saveMatch")
    public Match save(@RequestBody Match match) {
        // generate sequence
        match.setId((long) sequenceGeneratorService.getSequenceNumber(Match.SEQUENCE_NAME));
        return matchRepository.save(match);
    }

    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> findById(@PathVariable long id) {
        System.out.println(id);
        Match match = matchService.findMatchById(id);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{round}/{home}/{away}")
    public ResponseEntity<Match> findByRoundAndHomeAndAway(@PathVariable String round, @PathVariable String home, @PathVariable String away) {
        Match match = matchService.findByRoundAndHomeAndAway(round, home, away);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

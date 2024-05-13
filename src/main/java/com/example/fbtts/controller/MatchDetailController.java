package com.example.fbtts.controller;

import com.example.fbtts.entity.Market;
import com.example.fbtts.entity.MatchDetail;
import com.example.fbtts.repository.MatchDetailRepository;
import com.example.fbtts.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detailed_matches")
@AllArgsConstructor
public class MatchDetailController {
    @Autowired
    private MatchDetailRepository matchDetailRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/saveMatchDetail")
    public MatchDetail save(@RequestBody MatchDetail matchDetail) {
        // generate sequence
        matchDetail.setId((long) sequenceGeneratorService.getSequenceNumber(MatchDetail.SEQUENCE_NAME));
        return matchDetailRepository.save(matchDetail);
    }
}

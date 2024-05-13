package com.example.fbtts.service;

import com.example.fbtts.entity.MatchDetail;
import com.example.fbtts.repository.MatchDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MatchDetailService {
    private MatchDetailRepository matchDetailRepository;

    public MatchDetail findbyMatchId(Long matchId) {
        return matchDetailRepository.findByMatchId(matchId);
    }
}

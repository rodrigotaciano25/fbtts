package com.example.fbtts.service;

import com.example.fbtts.entity.Team;
import com.example.fbtts.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }
}

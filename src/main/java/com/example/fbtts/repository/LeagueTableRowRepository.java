package com.example.fbtts.repository;

import com.example.fbtts.entity.LeagueTableRow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueTableRowRepository extends MongoRepository<LeagueTableRow, Long> {
    public LeagueTableRow findByTeamId(long teamId);
    public LeagueTableRow findByTeam(String team);
}

package com.example.fbtts.service;

import com.example.fbtts.entity.DashboardStrategy;
import com.example.fbtts.repository.DashboardStrategyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DashboardStrategyService {
    private DashboardStrategyRepository dashboardStrategyRepository;

    public DashboardStrategy findByTitleAndUser(String title, String user) {
        System.out.println("Searching for league with the title " + title + "and user: " + user);
        DashboardStrategy dashboardStrategy = dashboardStrategyRepository.findByTitleAndUser(title, user);
        System.out.println("Found league: " + dashboardStrategy);
        return dashboardStrategy;
    }
}

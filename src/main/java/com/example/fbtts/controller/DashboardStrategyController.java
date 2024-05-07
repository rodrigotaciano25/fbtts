package com.example.fbtts.controller;

import com.example.fbtts.entity.DashboardStrategy;
import com.example.fbtts.service.DashboardStrategyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboardstrategies")
@AllArgsConstructor
public class DashboardStrategyController {
    private DashboardStrategyService dashboardStrategyService;

    @GetMapping("/{title}/{user}")
    public ResponseEntity<DashboardStrategy> findByTitleAndUser(@PathVariable String title, @PathVariable String user) {
        System.out.println(title);
        System.out.println(user);
        DashboardStrategy dashboardStrategy = dashboardStrategyService.findByTitleAndUser(title, user);
        if (dashboardStrategy != null) {
            return ResponseEntity.ok(dashboardStrategy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

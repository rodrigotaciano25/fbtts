package com.example.fbtts.controller;

import com.example.fbtts.entity.Market;
import com.example.fbtts.service.MarketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/markets")
@AllArgsConstructor
public class MarketController {
    private MarketService marketService;

    @GetMapping("/{id}")
    public ResponseEntity<Market> findById(@PathVariable int id) {
        System.out.println(id);
        Market market = marketService.findById(id);
        if (market != null) {
            return ResponseEntity.ok(market);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

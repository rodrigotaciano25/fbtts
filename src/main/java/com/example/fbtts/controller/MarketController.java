package com.example.fbtts.controller;

import com.example.fbtts.entity.Market;
import com.example.fbtts.repository.MarketRepository;
import com.example.fbtts.service.MarketService;
import com.example.fbtts.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/markets")
@AllArgsConstructor
public class MarketController {
    private MarketService marketService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private MarketRepository marketRepository;

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

    @PostMapping("/saveMarket")
    public Market save(@RequestBody Market market) {
        // generate sequence
        market.setId((long) sequenceGeneratorService.getSequenceNumber(Market.SEQUENCE_NAME));
        return marketRepository.save(market);
    }

}

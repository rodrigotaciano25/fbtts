package com.example.fbtts.service;

import com.example.fbtts.entity.Market;
import com.example.fbtts.repository.MarketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarketService {
    private final MarketRepository marketRepository;

    public Market findById(int id) {
        return marketRepository.findById(id);
    }
}

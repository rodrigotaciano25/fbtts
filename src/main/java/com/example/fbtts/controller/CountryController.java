package com.example.fbtts.controller;

import com.example.fbtts.entity.Country;
import com.example.fbtts.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable long id) {
        System.out.println(id);
        Country country = countryService.findById(id);
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

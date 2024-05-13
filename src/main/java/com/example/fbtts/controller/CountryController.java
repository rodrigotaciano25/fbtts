package com.example.fbtts.controller;

import com.example.fbtts.entity.Country;
import com.example.fbtts.repository.CountryRepository;
import com.example.fbtts.service.CountryService;
import com.example.fbtts.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    private CountryService countryService;

    @PostMapping("/saveCountry")
    public Country saveCountry(@RequestBody Country country) {
        country.setId((long) sequenceGeneratorService.getSequenceNumber(Country.SEQUENCE_NAME));
        return countryRepository.save(country);
    }

    @GetMapping("countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

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

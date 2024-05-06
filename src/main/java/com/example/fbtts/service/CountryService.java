package com.example.fbtts.service;

import com.example.fbtts.entity.Country;
import com.example.fbtts.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public Country findById(long id) {
        System.out.println("Searching for league with id: " + id); // Add this line for debugging
        Country country = countryRepository.findById(id);
        System.out.println("Found country: " + country); // Add this line for debugging
        return country;
    }

}

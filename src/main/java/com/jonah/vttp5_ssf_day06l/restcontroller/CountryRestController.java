package com.jonah.vttp5_ssf_day06l.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_ssf_day06l.model.Country;
import com.jonah.vttp5_ssf_day06l.service.CountryRestService;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {
    @Autowired
    CountryRestService countryRestService;

    @GetMapping()
    public ResponseEntity<List<Country>> getCountries() {

        List<Country> countries = new ArrayList<>();
        countries = countryRestService.getCountries();
        return ResponseEntity.ok().body(countries);

    }


}

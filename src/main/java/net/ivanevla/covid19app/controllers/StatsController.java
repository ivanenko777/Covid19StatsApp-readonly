package net.ivanevla.covid19app.controllers;

import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.dto.CountryDto;
import net.ivanevla.covid19app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countryStats")
public class StatsController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}")
    public ResponseEntity<?> getStatsByCounty(@PathVariable long countryId) {
        Country countryFromDb = countryService.findCountryByName(countryId);
        if (countryFromDb == null)
            return new ResponseEntity<String>("Country not found", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<CountryDto>(new CountryDto(countryFromDb), HttpStatus.OK);
    }
}

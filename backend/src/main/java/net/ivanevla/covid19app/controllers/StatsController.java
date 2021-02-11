package net.ivanevla.covid19app.controllers;

import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.domain.CountryStats;
import net.ivanevla.covid19app.domain.Indicator;
import net.ivanevla.covid19app.dto.CountryDataByIndicatorDto;
import net.ivanevla.covid19app.dto.CountryDataDto;
import net.ivanevla.covid19app.dto.CountryDto;
import net.ivanevla.covid19app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stats")
//@CrossOrigin
public class StatsController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<Country> countryListFromDb = (List<Country>) countryService.getCountriesList();
        List<CountryDto> countryDtoList = countryListFromDb.stream()
                .map(country -> new CountryDto(country.getId(), country.getName()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<?> getStatsByCountryOld(@PathVariable long countryId) {
        Country countryFromDb = countryService.findCountryByName(countryId);
        if (countryFromDb == null)
            return new ResponseEntity<String>("Country not found", HttpStatus.BAD_REQUEST);

        CountryDataDto countryDataDto = countryService.convertToCountryDataDto(countryFromDb);

        return new ResponseEntity<CountryDataDto>(countryDataDto, HttpStatus.OK);
    }
}

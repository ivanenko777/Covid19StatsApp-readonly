package net.ivanevla.covid19app.services;

import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country findCountryByName(long countryId) {
        Country country = countryRepository.findById(countryId).get();
        return country;
    }

    public Country findOrCreateNewCountry(Country country) {
        String countryName = country.getName();
        Country countryFromDb = countryRepository.findCountryByName(countryName);
        if (countryFromDb != null) return countryFromDb;
        return countryRepository.save(country);
    }
}

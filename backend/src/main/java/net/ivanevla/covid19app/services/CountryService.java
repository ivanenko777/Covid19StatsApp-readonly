package net.ivanevla.covid19app.services;

import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.domain.CountryStats;
import net.ivanevla.covid19app.domain.Indicator;
import net.ivanevla.covid19app.dto.CountryDataByIndicatorDto;
import net.ivanevla.covid19app.dto.CountryDataDto;
import net.ivanevla.covid19app.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Iterable<Country> getCountriesList() {
        return countryRepository.findAll();
    }

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

    public CountryDataDto convertToCountryDataDto(Country country) {
        CountryDataDto countryDataDto = new CountryDataDto(country.getName());

        List<CountryStats> countryStats = country.getCountryStats();

        List<String> labels = countryStats.stream()
                .map(stat -> stat.getYearWeek())
                .distinct()
                .collect(Collectors.toList());
        countryDataDto.setLabels(labels);

        List<CountryDataByIndicatorDto> datasets = Arrays.asList(
                convertToCountryDataByIndicatorDto(countryStats, Indicator.CASES),
                convertToCountryDataByIndicatorDto(countryStats, Indicator.DEATHS)
        );
        countryDataDto.setDatasets(datasets);

        return countryDataDto;
    }

    private CountryDataByIndicatorDto convertToCountryDataByIndicatorDto(List<CountryStats> countryStats, Indicator indicator) {
        String label = indicator.name();
        List<Integer> data = countryStats.stream()
                .filter(stat -> stat.getIndicator().equals(indicator))
                .map(stat -> stat.getWeeklyCount())
                .collect(Collectors.toList());
        return new CountryDataByIndicatorDto(label, data);
    }
}

package net.ivanevla.covid19app.dto;

import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.domain.CountryStats;

import java.util.*;
import java.util.stream.Collectors;

public class CountryDto {
    private Long id;
    private String name;
    private String code;
    private String continent;
    private Long population;
    private Map<String, List<CountryStatsDto>> countryStats;

    public CountryDto() {
    }

    public CountryDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
        this.code = country.getCode();
        this.continent = country.getContinent();
        this.population = country.getPopulation();
        this.countryStats = new HashMap<>();

        convertToAndSortCountryStatsDto(country.getCountryStats());
    }

    private void convertToAndSortCountryStatsDto(List<CountryStats> countryStats) {
        for (CountryStats stat : countryStats) {
            String key = stat.getYearWeek();
            this.countryStats.putIfAbsent(key, new ArrayList<>());
            List<CountryStatsDto> countryStatsDtoList = this.countryStats.get(key);
            countryStatsDtoList.add(new CountryStatsDto(stat));
            this.countryStats.put(key, countryStatsDtoList);
        }

        this.countryStats = this.countryStats.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    public Long getPopulation() {
        return population;
    }

    public Map<String, List<CountryStatsDto>> getCountryStats() {
        return countryStats;
    }
}

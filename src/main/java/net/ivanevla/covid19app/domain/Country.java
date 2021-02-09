package net.ivanevla.covid19app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private String continent;
    private Long population;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<CountryStats> countryStats;

    public Country() {
    }

    public Country(String name, String code, String continent, Long population) {
        this.name = name;
        this.code = code;
        this.continent = continent;
        this.population = population;
        countryStats = new ArrayList<>();
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

    public List<CountryStats> getCountryStats() {
        return countryStats;
    }

    public void setCountryStats(List<CountryStats> countryStats) {
        this.countryStats = countryStats;
    }
}

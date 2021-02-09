package net.ivanevla.covid19app.services;

import net.ivanevla.covid19app.domain.CountryStats;
import net.ivanevla.covid19app.repositories.CountryStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryStatsService {
    @Autowired
    private CountryStatsRepository countryStatsRepository;

    public CountryStats createStatsItem(CountryStats countryStats) {
        return countryStatsRepository.save(countryStats);
    }
}

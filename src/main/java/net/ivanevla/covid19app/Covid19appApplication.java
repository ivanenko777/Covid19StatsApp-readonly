package net.ivanevla.covid19app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ivanevla.covid19app.domain.Country;
import net.ivanevla.covid19app.domain.CountryStats;
import net.ivanevla.covid19app.domain.Indicator;
import net.ivanevla.covid19app.services.CountryService;
import net.ivanevla.covid19app.services.CountryStatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Covid19appApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(Covid19appApplication.class);
    private static final String DATA_SOURCE_URL = "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";

    public static void main(String[] args) {
        SpringApplication.run(Covid19appApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CountryService countryService, CountryStatsService countryStatsService) {
        return args -> {
            LOGGER.info("Loading data form JSON");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, String>> dataItems = objectMapper.readValue(new URL(DATA_SOURCE_URL), new TypeReference<>() {
            });
            LOGGER.info("Data loaded");

            dataItems.forEach(item -> {
                String countryName = item.get("country");
                String countryCode = item.get("country_code");
                String countryContinent = item.get("continent");
                Long countryPopulation = Long.parseLong(item.get("population"));
                Country country = countryService.findOrCreateNewCountry(new Country(countryName, countryCode, countryContinent, countryPopulation));

                String yearWeek = item.get("year_week");
                String indicatorString = item.get("indicator").toUpperCase();
                Indicator indicator = Indicator.valueOf(indicatorString);
                int weeklyCount = Integer.parseInt(item.get("weekly_count"));
                int cumulativeCount = Integer.parseInt(item.get("cumulative_count"));
                double rate14Day = item.get("rate_14_day") == null ? 0.0 : Double.parseDouble(item.get("rate_14_day"));
                String source = item.get("source");
                countryStatsService.createStatsItem(new CountryStats(country, yearWeek, indicator, weeklyCount, cumulativeCount, rate14Day, source));
            });
        };
    }
}

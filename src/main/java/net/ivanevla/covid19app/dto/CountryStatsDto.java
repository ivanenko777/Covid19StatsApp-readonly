package net.ivanevla.covid19app.dto;

import net.ivanevla.covid19app.domain.CountryStats;

public class CountryStatsDto {
    private String indicator;
    private int weeklyCount;
    private int cumulativeCount;
    private double rate14Day;
    private String source;

    public CountryStatsDto() {
    }

    public CountryStatsDto(CountryStats countryStats) {
        this.indicator = countryStats.getIndicator();
        this.weeklyCount = countryStats.getWeeklyCount();
        this.cumulativeCount = countryStats.getCumulativeCount();
        this.rate14Day = countryStats.getRate14Day();
        this.source = countryStats.getSource();
    }

    public String getIndicator() {
        return indicator;
    }

    public int getWeeklyCount() {
        return weeklyCount;
    }

    public int getCumulativeCount() {
        return cumulativeCount;
    }

    public double getRate14Day() {
        return rate14Day;
    }

    public String getSource() {
        return source;
    }
}

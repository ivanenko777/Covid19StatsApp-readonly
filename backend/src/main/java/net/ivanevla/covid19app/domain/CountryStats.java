package net.ivanevla.covid19app.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(indexes = @Index(columnList = "country_id"))
public class CountryStats implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    private String yearWeek;

    @Enumerated(EnumType.STRING)
    private Indicator indicator;
    private int weeklyCount;
    private int cumulativeCount;
    private double rate14Day;
    private String source;

    public CountryStats() {
    }

    public CountryStats(Country country, String yearWeek, Indicator indicator, int weeklyCount, int cumulativeCount, double rate14Day, String source) {
        this.country = country;
        this.yearWeek = yearWeek;
        this.indicator = indicator;
        this.weeklyCount = weeklyCount;
        this.cumulativeCount = cumulativeCount;
        this.rate14Day = rate14Day;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getYearWeek() {
        return yearWeek;
    }

    public Indicator getIndicator() {
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

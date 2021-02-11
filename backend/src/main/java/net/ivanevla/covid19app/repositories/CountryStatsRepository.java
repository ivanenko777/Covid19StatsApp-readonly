package net.ivanevla.covid19app.repositories;

import net.ivanevla.covid19app.domain.CountryStats;
import org.springframework.data.repository.CrudRepository;

public interface CountryStatsRepository extends CrudRepository<CountryStats, Long> {
}

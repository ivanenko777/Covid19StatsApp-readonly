package net.ivanevla.covid19app.repositories;

import net.ivanevla.covid19app.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findCountryByName(String countryName);
}

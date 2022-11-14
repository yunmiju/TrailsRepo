package ubc.cpsc304.repository;
import org.junit.jupiter.api.Test;
import ubc.cpsc304.domain.Countries;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

@Slf4j
class CountriesRepositoryV0Test {
    CountriesRepositoryV0 repository = new CountriesRepositoryV0();
    private Countries countries;

    @Test
    void crud() throws SQLException {
        //save
        Countries countries = new Countries("CANADA");
        // repository.save(countries);
        // find
        String name = countries.getCountryName();
        Countries findCountries = repository.findByName(countries.getCountryName());
        // Countries findCountries = repository.findAll("'" + countries.getCountryName() + "'");
        log.info("find = {}", findCountries);
        assertThat(findCountries).isEqualTo(countries);

    }
}

package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ubc.cpsc304.domain.Countries;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class CountriesRepositoryV1Test {
    CountriesRepositoryV0 repository = new CountriesRepositoryV0();
    private Countries countries;

    @Test
    void crud() throws SQLException {
        //save
        Countries country = new Countries("CANADA");
        //repository.save(country);

        // find
        Countries target = repository.findByName(country.getCountryName());
        log.info("find = {}", target);
        assertThat(target).isEqualTo(country);
        assertThat(target).isNotNull();

        //find All
//        Set<String> countries = repository.findAll();
//        assertThat(countries).isNotNull();
//        log.info("findAll = {}", countries);
    }
}

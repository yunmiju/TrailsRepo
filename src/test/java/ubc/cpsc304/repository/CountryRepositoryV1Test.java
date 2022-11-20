package ubc.cpsc304.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubc.cpsc304.domain.Countries;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class CountryRepositoryV1Test {

//    CountryRepositoryV1 countryRepositoryV1;
//
//    @BeforeEach
//    void beforeEach() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl(ORACLE_URL);
//        dataSource.setUsername(USER_NAME);
//        dataSource.setPassword(PASSWORD);
//        dataSource.setMaximumPoolSize(3);
//        dataSource.setPoolName("MyPool");
//        countryRepositoryV1 = new CountryRepositoryV1(dataSource);
//    }

    @Test
    void curd() throws SQLException {
//        Countries c = new Countries("FRANCE");
//        int rst = countryRepositoryV1.addCountry(c);
//        assertThat(rst).isEqualTo(1);
//        List<Country> findCountry = countryRepositoryV1.getAll();
//        log.info("findCountry = {}", findCountry);

//        Countries findCountry = countryRepositoryV1.getByName(c.getCname());
//        log.info("length = {}", findCountry.size());
//        log.info(String.valueOf(findCountry.get(1)));
//        assertThat(findCountry.getCname()).isEqualTo(c.getCname());
    }
}

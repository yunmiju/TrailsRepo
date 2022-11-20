package ubc.cpsc304.repository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubc.cpsc304.services.Parks;
import ubc.cpsc304.domain.ParkA;

import java.sql.SQLException;
import java.util.List;

import static ubc.cpsc304.database.ConnectionConst.*;


@Slf4j
public class ParksTest {
    Parks parks;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ORACLE_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");
        parks = new Parks(dataSource);
    }

        @Test
    void curdCombineParksByProvinceName() throws SQLException {
        List<ParkA> combined = parks.combineParksByProvinceName("BC");
        log.info("combined = {}", combined);
    }
}
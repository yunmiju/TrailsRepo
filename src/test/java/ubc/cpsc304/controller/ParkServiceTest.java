package ubc.cpsc304.controller;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.service.ParkService;

import java.sql.SQLException;
import java.util.List;

import static ubc.cpsc304.database.ConnectionConst.*;


@Slf4j
public class ParkServiceTest {
    ParkService parkService;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ORACLE_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");
        parkService = new ParkService(dataSource);
    }

        @Test
    void curdCombineParksByProvinceName() throws SQLException {
        List<ParkA> combined = parkService.combineParksByProvinceName("BC");
        log.info("combined = {}", combined);
    }
}
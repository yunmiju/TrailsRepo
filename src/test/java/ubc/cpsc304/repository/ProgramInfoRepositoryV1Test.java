package ubc.cpsc304.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ubc.cpsc304.domain.ProgramInfo;

import java.sql.SQLException;

import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
class ProgramInfoRepositoryV1Test {

    ProgramInfoRepositoryV1 repository;

    @BeforeEach
    void beforeEach() {
        // get new connection each time
        // DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);

        // connection pooling
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ORACLE_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setPoolName("programInfo");
        repository = new ProgramInfoRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        // ProgramInfo programInfo = new ProgramInfo(6, 1002, "Explore Nature", 10);
        // repository.save(programInfo);

        ProgramInfo programInfo = new ProgramInfo();
        repository.findAll();

        //findById
        ProgramInfo findProgram = repository.findByVisitorCenterId(1002);
        log.info("findProgram={}", findProgram);
        assertThat(findProgram.getVisitorCenterId()).isEqualTo(1002);

        //update:

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
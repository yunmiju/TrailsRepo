package ubc.cpsc304.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import ubc.cpsc304.domain.ProgramInfo;

import java.sql.SQLException;
import java.util.Set;

import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
class ProgramRepositoryTest {

  ProgramRepository repository;

  @BeforeEach
  void beforeEach() throws Exception {
    // get new connection each time
    // DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL,
    // USER_NAME, PASSWORD);

    // connection pooling
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(ORACLE_URL);
    dataSource.setUsername(USER_NAME);
    dataSource.setPassword(PASSWORD);
    dataSource.setPoolName("programInfo");
    dataSource.setMaximumPoolSize(1);
    repository = new ProgramRepository(dataSource);
  }

  @Test
  void crud() throws SQLException, InterruptedException {
    ProgramInfo program = new ProgramInfo(6, 1002, "Explore the wild", 10);
    // repository.save(program);
    ProgramInfo target = new ProgramInfo();
    Set<String> list = repository.findAll();
    System.out.println(list);
    //findById
    ProgramInfo findProgram = repository.findByVisitorCenterId(1002);
    log.info("findProgram={}", findProgram);
    assertThat(findProgram).isNotNull();
    assertThat(findProgram.getVisitorCenterId()).isEqualTo(1002);

    // update:

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
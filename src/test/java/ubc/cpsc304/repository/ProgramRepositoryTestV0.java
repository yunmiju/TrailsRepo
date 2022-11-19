//package ubc.cpsc304.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static ubc.cpsc304.database.ConnectionConst.ORACLE_URL;
//import static ubc.cpsc304.database.ConnectionConst.PASSWORD;
//import static ubc.cpsc304.database.ConnectionConst.USER_NAME;
//
//import com.zaxxer.hikari.HikariDataSource;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Set;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.Transactional;
//import ubc.cpsc304.domain.Program;
//import ubc.cpsc304.domain.ProgramInfo;
//
//@Slf4j
//@Transactional
//@SpringBootTest
//class ProgramRepositoryTestV0 {
//
//  ProgramRepositoryV2 repository;
//
//  @BeforeEach
//  void beforeEach() throws Exception {
//     // get new connection each time
////     DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL,
////     USER_NAME, PASSWORD);
//
//    // connection pooling
//    HikariDataSource dataSource = new HikariDataSource();
//    dataSource.setJdbcUrl(ORACLE_URL);
//    dataSource.setUsername(USER_NAME);
//    dataSource.setPassword(PASSWORD);
//    dataSource.setPoolName("programInfo");
//    dataSource.setMaximumPoolSize(1);
//    repository = new ProgramRepositoryV2(dataSource);
//  }
//
//  @Test
//  void crud() throws SQLException, InterruptedException {
//    ProgramInfo programInfo = new ProgramInfo(6, 1002, "Explore the wild", 10);
//    // repository.save(program);
//
//    ProgramInfo target = new ProgramInfo();
//    Program program = new Program();
//    List<Program> programs = repository.findAll();
//    System.out.println(programs);
//
//    //findById
//    List<Program> findPrograms = repository.findByParkId(102);
//    log.info("findProgram={}", findPrograms);
//    assertThat(findPrograms).isNotNull();
//
//    // update:
//
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
//}
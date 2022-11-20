package ubc.cpsc304.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ubc.cpsc304.repository.ProgramRepository;
import ubc.cpsc304.repository.ProgramRepositoryV2;
import ubc.cpsc304.service.ParkService;
import ubc.cpsc304.service.ProgramService;

import javax.sql.DataSource;
import ubc.cpsc304.service.ProgramServiceV2;

import java.sql.Connection;
import java.sql.DriverManager;

import static ubc.cpsc304.database.ConnectionConst.*;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

  private final DataSource dataSource;

  @Bean
  public ProgramService programService() {
    return new ProgramServiceV2(programRepository());
  }

  @Bean
  public ProgramRepository programRepository() {
    return new ProgramRepositoryV2(dataSource);
  }

  @Bean
  public ParkService parkService() {
    return new ParkService(dataSource);
  }
}
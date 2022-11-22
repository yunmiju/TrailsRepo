package ubc.cpsc304.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ubc.cpsc304.repository.ParkDetailsRepository;
import ubc.cpsc304.repository.ParkDetailsRepositoryV1;
import ubc.cpsc304.repository.ProgramRepository;
import ubc.cpsc304.repository.ProgramRepositoryV2;
import ubc.cpsc304.repository.ProgramReservationRepository;
import ubc.cpsc304.repository.ProgramReservationRepositoryV2;
import ubc.cpsc304.service.ParkDetailsService;
import ubc.cpsc304.service.ParkDetailsServiceV1;
import ubc.cpsc304.service.ParkService;
import ubc.cpsc304.service.ProgramReservationService;
import ubc.cpsc304.service.ProgramReservationServiceV2;
import ubc.cpsc304.service.ProgramService;
import ubc.cpsc304.service.ProgramServiceV2;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

  private final DataSource dataSource;

  @Bean
  public ParkDetailsService parkDetailsService() {
    return new ParkDetailsServiceV1(parkDetailsRepository());
  }

  @Bean
  public ParkDetailsRepository parkDetailsRepository() {
    return new ParkDetailsRepositoryV1(dataSource);
  }

  @Bean
  public ProgramService programService() {
    return new ProgramServiceV2(programRepository());
  }

  @Bean
  public ProgramRepository programRepository() {
    return new ProgramRepositoryV2(dataSource);
  }

  @Bean
  public ProgramReservationService programReservationService() {
    return new ProgramReservationServiceV2(programReservationRepository());
  }

  @Bean
  public ProgramReservationRepository programReservationRepository() {
    return new ProgramReservationRepositoryV2(dataSource);
  }

  @Bean
  public ParkService parkService() {
    return new ParkService(dataSource);
  }
}

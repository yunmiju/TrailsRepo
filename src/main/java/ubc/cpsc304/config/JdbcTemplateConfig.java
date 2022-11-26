package ubc.cpsc304.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ubc.cpsc304.repository.*;
import ubc.cpsc304.repository.DTO.TrailDto;
import ubc.cpsc304.service.*;

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

  @Bean
  public TrailService trailService() {
    return new TrailServiceV2(trailRepository());
  }

  @Bean
  public TrailRepository trailRepository() {
    return new TrailRepository(dataSource);
  }

  @Bean
  public TrailImageService trailImageService() {
    return new TrailImageService(dataSource);
  }
}

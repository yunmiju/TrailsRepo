//package ubc.cpsc304.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import ubc.cpsc304.domain.Countries;
//
//import java.sql.SQLException;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@Slf4j
//class CountriesRepositoryV1Test {
//  CountriesRepositoryV1 repository = new CountriesRepositoryV1();
//  private Countries countries;
//
//  @Test
//  void crud() throws SQLException {
//    // save
//    Countries country = new Countries("CANADA");
//    // repository.save(country);
//
//    // find All
//    Set<String> countries = repository.findAll();
//    assertThat(countries).isNotNull();
//    log.info("findAll = {}", countries);
//
//    // find
//    Countries target = repository.findByName(country.getCountryName());
//    log.info("find = {}", target);
//    assertThat(target).isEqualTo(country);
//    assertThat(target).isNotNull();
//
//  }
//}

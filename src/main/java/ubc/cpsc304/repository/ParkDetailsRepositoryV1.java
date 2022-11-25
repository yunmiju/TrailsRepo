package ubc.cpsc304.repository;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ubc.cpsc304.repository.DTO.ParkDetailsDto;

@Slf4j
public class ParkDetailsRepositoryV1 implements ParkDetailsRepository {

  private final NamedParameterJdbcTemplate template;

  public ParkDetailsRepositoryV1(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
  }

  @Override
  public ParkDetailsDto parkInfoById(Integer parkId) {
    String sql = "SELECT " +
        "DISTINCT(parks.id), "
        + "parks.park_name, "
        + "parks.park_address, "
        + "parks.open_hour, "
        + "parks.close_hour, "
        + "centers.center_name, "
        + "centers.email, "
        + "centers.center_address, "
        + "p.province_name, "
        + "p.country_name, "
        + "restricted_park.permit_type, "
        + "public_park.camping_site, "
        + "(SELECT COUNT(DISTINCT program_info.id) "
        + "FROM program_info "
        + "WHERE program_info.visitor_center_id = centers.id "
        + "GROUP BY centers.id) AS programNums "
        + "FROM parks "
        + "LEFT OUTER JOIN restricted_park on parks.id = restricted_park.id "
        + "LEFT OUTER JOIN public_park on parks.id = public_park.id "
        + "LEFT JOIN visitor_centers centers on parks.id = centers.park_id "
        + "JOIN provinces p on p.id = parks.province_id "
        + "WHERE park_id=:parkId";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("parkId", parkId);
    return template.queryForObject(sql, param, parkDetailRowMapper());
  }

  private RowMapper<ParkDetailsDto> parkDetailRowMapper() {
    return BeanPropertyRowMapper.newInstance(ParkDetailsDto.class);
  }
}

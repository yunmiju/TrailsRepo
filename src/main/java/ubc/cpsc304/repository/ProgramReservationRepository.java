package ubc.cpsc304.repository;

import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.ProgramReservationSearchCond;
import ubc.cpsc304.repository.ProgramReservationUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class ProgramReservationRepository {

  private final NamedParameterJdbcTemplate template;
  private final JdbcTemplate templatePrev;
  private final SimpleJdbcInsert jdbcInsert;

  public ProgramReservationRepository(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
    this.templatePrev = new JdbcTemplate(dataSource);
    this.jdbcInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("program_reservation")
        .usingGeneratedKeyColumns("id");
  }

  public ProgramReservation save(ProgramReservation programReservation) {
    SqlParameterSource param = new BeanPropertySqlParameterSource(programReservation);
    Number key = jdbcInsert.executeAndReturnKey(param);
    programReservation.setId(key.intValue());
    String sql = "insert into program_reservation " +
        "(id, reservationNumber, email, ppl) " +
        "values (, ?, ?, ?)";
    templatePrev.update(sql, programReservation.getId(), programReservation.getReservationNumber(),
        programReservation.getEmail(), programReservation.getPpl());

    return programReservation;
  }

  public void update(int id, ProgramReservationUpdateDto updateParam) {
    String sql = "update program_reservation " +
        "set email=:email, ppl=:ppl " +
        "where id=:id";

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("email", updateParam.getEmail())
        .addValue("ppl", updateParam.getPpl());

    template.update(sql, param);
  }

  public void delete(int id) {
    String sql = "delete from program_reservation where id:id";

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("id", id);
        
    template.update(sql, param);
  }

  public List<ProgramReservation> findAll(ProgramReservationSearchCond cond) {
    String reservationNumber = cond.getReservationNumber();
    String email = cond.getEmail();

    SqlParameterSource param = new BeanPropertySqlParameterSource(cond);

    String sql = "select * from program_reservation ";

    if (StringUtils.hasText(reservationNumber) || StringUtils.hasText(email)) {
      sql += " where";
    }

    boolean andFlag = false;
    if (StringUtils.hasText(reservationNumber)) {
      sql += " reservation_number like concat('%',:reservationNumber,'%')";
      andFlag = true;
    }

    if (StringUtils.hasText(email)) {
      if (andFlag) {
        sql += " and";
      }
      sql += " email like concat('%',:email,'%')";
    }

    log.info("sql={}", sql);
    return template.query(sql, param, programReservationRowMapper());
  }

  private RowMapper<ProgramReservation> programReservationRowMapper() {
    return BeanPropertyRowMapper.newInstance(ProgramReservation.class); // camel 변환 지원
  }
}

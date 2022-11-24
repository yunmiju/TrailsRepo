package ubc.cpsc304.repository;

import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.StringUtils;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.DTO.ProgramReservationSearchCond;
import ubc.cpsc304.repository.DTO.ReservationRequestDto;

@Slf4j
public class ProgramReservationRepositoryV2 implements ProgramReservationRepository {

  private final NamedParameterJdbcTemplate template;
  private final JdbcTemplate templatePrev;
  private final SimpleJdbcInsert jdbcInsert;

  public ProgramReservationRepositoryV2(DataSource dataSource) {
    this.template = new NamedParameterJdbcTemplate(dataSource);
    this.templatePrev = new JdbcTemplate(dataSource);
    this.jdbcInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("program_reservation")
        .usingGeneratedKeyColumns("id");
  }

  @Override
  public ProgramReservation save(ProgramReservation programReservation) {
    // SqlParameterSource param = new BeanPropertySqlParameterSource(programReservation);
    // Number key = jdbcInsert.executeAndReturnKey(param);
    // programReservation.setId(key.intValue());

    String sql = "insert into program_reservation(program_id, reservation_number, email, ppl) " +
        "values (:programId, :reservationNumber, :email, :ppl)";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("programId", programReservation.getProgramId())
        .addValue("reservationNumber", programReservation.getReservationNumber())
        .addValue("email", programReservation.getEmail())
        .addValue("ppl", programReservation.getPpl());
    Integer result = template.update(sql, param);
    return programReservation;
  }

  @Override
  public Integer update(ReservationRequestDto updateParam) {
    String sql = "update program_reservation " +
        "set email=:email, ppl=:ppl " +
        "where reservation_number=:reservationNumber";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("email", updateParam.getEmail())
        .addValue("ppl", updateParam.getPpl())
        .addValue("reservationNumber", updateParam.getReservationNumber());
    return template.update(sql, param);
  }

  @Override
  public Integer delete(String reservationNumber) {
    String sql = "delete from program_reservation where reservation_number=:reservationNumber";

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("reservationNumber", reservationNumber);
    return template.update(sql, param);
  }

  @Override
  public ProgramReservation findByReservationNumber(String reservationNumber) {
    String sql = "select * from program_reservation where reservation_number=?";
    ProgramReservation updated = templatePrev.queryForObject(sql, programReservationRowMapper(),
        reservationNumber);
    return updated;
  }

  @Override
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
      sql += " reservation_number = :reservationNumber";
      andFlag = true;
    }

    if (StringUtils.hasText(email)) {
      if (andFlag) {
        sql += " and";
      }
      sql += " email =:email";
    }

    log.info("sql={}", sql);

    return template.query(sql, param, programReservationRowMapper());
  }

  private RowMapper<ProgramReservation> programReservationRowMapper() {
    return BeanPropertyRowMapper.newInstance(ProgramReservation.class);
  }
}

package ubc.cpsc304.repository;

import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.StringUtils;
import ubc.cpsc304.domain.ProgramReservation;
import ubc.cpsc304.repository.DTO.ProgramReservationSearchCond;
import ubc.cpsc304.repository.DTO.ReservationInfoDto;
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
  public Integer save(ProgramReservation programReservation) {
    String sql = "insert into program_reservation(program_id, reservation_number, email, ppl) " +
        "values (:programId, :reservationNumber, :email, :ppl)";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("programId", programReservation.getProgramId())
        .addValue("reservationNumber", programReservation.getReservationNumber())
        .addValue("email", programReservation.getEmail())
        .addValue("ppl", programReservation.getPpl());
    return template.update(sql, param);
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
  public ReservationInfoDto findInfoByReservationNumber(String reservationNumber) {
    String sql = "SELECT p.program_id, reservation_number, program_name, email, ppl " +
        "FROM program_reservation p " +
        "JOIN program_info pi ON p.program_id = pi.id " +
        "WHERE reservation_number=:reservationNumber";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("reservationNumber", reservationNumber);
    ReservationInfoDto updated = template.queryForObject(sql, param, reservationInfoDtoRowMapper());
    return updated;
  }

  @Override
  public List<ReservationInfoDto> findInfoByEmail(String email) {
    String sql = "select pp.program_id as program_id, pp.reservation_number as reservation_number, " +
        "filtered.program_name as program_name, pp.email as email, pp.ppl as ppl " +
        "from program_reservation pp join (select * from program_info p " +
        "where not exists " +
        "((select email from program_reservation p1 where p1.email=:email) " +
        "minus (select p2.email from program_reservation p2 " +
        "where p2.program_id=p.id))) filtered on pp.id=filtered.id";

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("email", email);
    List<ReservationInfoDto> updated = template.query(sql, param, reservationInfoDtoRowMapper());
    System.out.println("updated " + updated);
    return updated;
  }

  @Override
  public List<ReservationInfoDto> findAll(ProgramReservationSearchCond cond) {
    String reservationNumber = cond.getReservationNumber();
    String email = cond.getEmail();

    SqlParameterSource param = new BeanPropertySqlParameterSource(cond);

    String sql = "SELECT p.program_id, reservation_number, program_name, email, ppl " +
        "FROM program_reservation p " +
        "JOIN program_info pi ON p.program_id = pi.id";

    if (StringUtils.hasText(reservationNumber) || StringUtils.hasText(email)) {
      sql += " where";
    }

    boolean andFlag = false;
    if (StringUtils.hasText(reservationNumber)) {
      sql += " p.reservation_number = :reservationNumber";
      andFlag = true;
    }

    if (StringUtils.hasText(email)) {
      if (andFlag) {
        sql += " and";
      }
      sql += " p.email =:email";
    }

    log.info("sql={}", sql);

    return template.query(sql, param, reservationInfoDtoRowMapper());
  }

  private RowMapper<ProgramReservation> programReservationRowMapper() {
    return BeanPropertyRowMapper.newInstance(ProgramReservation.class);
  }

  private RowMapper<ReservationInfoDto> reservationInfoDtoRowMapper() {
    return BeanPropertyRowMapper.newInstance(ReservationInfoDto.class);
  }
}

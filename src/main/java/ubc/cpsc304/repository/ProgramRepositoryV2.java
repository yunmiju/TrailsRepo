package ubc.cpsc304.repository;

import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
public class ProgramRepositoryV2 implements ProgramRepository {

  private final NamedParameterJdbcTemplate template;
  private final JdbcTemplate templatePrev;
  private final SimpleJdbcInsert jdbcInsert;


  public ProgramRepositoryV2(DataSource dataSource) {
    this.templatePrev = new JdbcTemplate(dataSource);
    this.template = new NamedParameterJdbcTemplate(dataSource);
    this.jdbcInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("program_info")
        .usingGeneratedKeyColumns("id");
  }

  public ProgramInfo save(ProgramInfo programInfo) {
    String sql = "insert into Program_info " +
        "(id, visitor_center_id, program_name, capacity) " +
        "values (?, ?, ?, ?)";
    templatePrev.update(sql, programInfo.getId(), programInfo.getProgramName(),
        programInfo.getVisitorCenterId());
    return programInfo;

  }

  public List<Program> findAll() {
    String sql =
        "SELECT P.ID, P.PROGRAM_NAME, P.CAPACITY, P.PROGRAM_IMAGE AS ImgURL, P.DESCRIPTION, M.MANAGER_NAME " +
            "FROM PROGRAM_INFO P " +
            "JOIN VISITOR_CENTERS V " +
            "ON P.VISITOR_CENTER_ID = V.ID " +
            "JOIN PROGRAM_MANAGER PM on P.ID = PM.PROGRAM_ID " +
            "JOIN MANAGERS M on PM.MANAGER_ID = M.ID " +
            "ORDER BY P.PROGRAM_NAME";
    return template.query(sql, programRowMapper());
  }

  public List<Program> findByParkId(long parkId) {
    String sql =
        "select P.ID, P.PROGRAM_NAME, P.CAPACITY, P.PROGRAM_IMAGE AS ImgURL, P.DESCRIPTION, M.MANAGER_NAME " +
            "from PROGRAM_INFO P " +
            "JOIN VISITOR_CENTERS V " +
            "ON P.VISITOR_CENTER_ID = V.ID " +
            "JOIN PROGRAM_MANAGER PM on P.ID = PM.PROGRAM_ID " +
            "JOIN MANAGERS M on PM.MANAGER_ID = M.ID " +
            "WHERE V.PARK_ID=:parkId " +
            "ORDER BY P.PROGRAM_NAME";
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("parkId", parkId);

    return template.query(sql, param, programRowMapper());
  }

  public Optional<ProgramInfo> findById(int id) {
    String sql = "select * FROM program_info where id=:id";

    try {
      Map<String, Object> param = Map.of("id", id);
      ProgramInfo programInfo = template.queryForObject(sql, param, programInfoRowMapper());
      return Optional.of(programInfo);
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  // private RowMapper<Program> ProgramRowMapper() {
  //   return (rs, rowNum) -> {
  //     Program program = new Program();
  //     program.setId(rs.getInt("id"));
  //     program.setName(rs.getString("program_name"));
  //     program.setCapacity(rs.getInt("capacity"));
  //     program.setImgURL(rs.getString("program_image"));
  //     program.setDescription(rs.getString("description");
  //     program.setManagerName(rs.getString("manager_name"));
  //     return program;
  //   };
  // }

  private RowMapper<Program> programRowMapper() {
    return BeanPropertyRowMapper.newInstance(Program.class); // camel 변환 지원
  }

  private RowMapper<ProgramInfo> programInfoRowMapper() {
    return BeanPropertyRowMapper.newInstance(ProgramInfo.class); // camel 변환 지원
  }
}

package ubc.cpsc304.repository;

import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

import java.util.*;

@Slf4j
public class ProgramRepository {

  private final JdbcTemplate template;

  public ProgramRepository(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  public ProgramInfo save(ProgramInfo programInfo) {
    String sql = "insert into Program_info " +
        "(id, visitor_center_id, program_name, capacity) " +
        "values (?, ?, ?, ?)";
    template.update(sql, programInfo.getId(), programInfo.getProgramName(), programInfo.getVisitorCenterId());
    return programInfo;

  }

  public List<Program> findAll() {
    String sql = "SELECT P.PROGRAM_NAME, P.CAPACITY, P.PROGRAM_IMAGE, P.DESCRIPTION, M.MANAGER_NAME " +
                  "FROM PROGRAM_INFO P " +
                  "JOIN VISITOR_CENTERS V " +
                  "ON P.VISITOR_CENTER_ID = V.ID " +
                  "JOIN PROGRAM_MANAGER PM on P.ID = PM.PROGRAM_ID " +
                  "JOIN MANAGERS M on PM.MANAGER_ID = M.ID " +
                  "ORDER BY P.PROGRAM_NAME";
    log.info("sql={}", sql);
    return template.query(sql, ProgramRowMapper());
  }

  public List<Program> findByParkId(int parkId) {
    String sql = "select P.PROGRAM_NAME, P.CAPACITY, P.PROGRAM_IMAGE, P.DESCRIPTION, M.MANAGER_NAME " +
                  "from PROGRAM_INFO P " +
                  "JOIN VISITOR_CENTERS V " +
                  "ON P.VISITOR_CENTER_ID = V.ID " +
                  "JOIN PROGRAM_MANAGER PM on P.ID = PM.PROGRAM_ID " +
                  "JOIN MANAGERS M on PM.MANAGER_ID = M.ID "+
                  "WHERE V.PARK_ID = 102 " +
                  "ORDER BY P.PROGRAM_NAME";
    return template.query(sql, ProgramRowMapper(), parkId);
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

  private RowMapper<Program> ProgramRowMapper() {
    return BeanPropertyRowMapper.newInstance(Program.class); // camel 변환 지원
  }
}

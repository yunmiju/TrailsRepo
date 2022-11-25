//package ubc.cpsc304.repository;
//
//import java.util.List;
//import java.lang.String;
//import javax.sql.DataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.JdbcTemplate;
////import ubc.cpsc304.domain.TrailImage;
//import ubc.cpsc304.domain.Seasons;
//import ubc.cpsc304.domain.TrailLevel;
//import ubc.cpsc304.domain.TrailSeason;
//import ubc.cpsc304.domain.TrailInfo;
////import ubc.cpsc304.Mapper.TrailImageMapper;
//import ubc.cpsc304.Mapper.TrailLevelMapper;
//import ubc.cpsc304.Mapper.TrailSeasonMapper;
//import ubc.cpsc304.Mapper.TrailInfoMapper;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Slf4j
//public class TrailRepository {
//    protected final DataSource dataSource;
//    protected JdbcTemplate jdbcTemplate;
//
//    public TrailRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//        jdbcTemplate = new JdbcTemplate(this.dataSource);
//    }
//
//    public List<TrailInfo> getByParkId(int parkId) {
//        return jdbcTemplate.query("select * from TrailInfo where park_id = ?",
//                new TrailInfoMapper());
//    }
//
//    public List<TrailInfo> getBySeason(Seasons season) {
//        String sql = "select * from Trail_info ti, Trail_season ts " +
//                "where ts.season_name = season";
//        return jdbcTemplate.query(sql, new TrailInfoMapper());
//    }
//
//    public List<TrailInfo> getByHut() {
//        String sql = "select * from Trail_info ti, Huts h group by trail_name " +
//                "having COUNT(*) > 0";
//        return jdbcTemplate.query(sql, new TrailInfoMapper());
//    }
//}

package ubc.cpsc304.repository;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ubc.cpsc304.repository.DTO.TrailDto;

@Slf4j
public class TrailRepository {
    private final NamedParameterJdbcTemplate template;

    public TrailRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public TrailDto trailInfoByParkIdAndTrailName(int id, String trailName) {
        String sql =
                "SELECT " +
                        "parks.id, " +
                        "trail_info.trail_name, " +
                        "trail_info.difficulty, " +
                        "trail_level.duration, " +
                        "trail_info.distance, " +
                        "trail_info.trail_description, " +
                        "trail_image.image_url " +
                        "FROM trail_info " +
                        "LEFT JOIN trail_image img on trail_info.trail_name =" +
                        " img.trail_name " +
                        "LEFT JOIN trail_level lvl on trail_info.distance = " +
                        "lvl.distance AND trail_info.difficulty = lvl" +
                        ".difficulty " +
                        "JOIN parks p on p.id = trail_info.park_id " +
                        "WHERE park_id=:parkId AND trail_name=:trailName";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("trailName", trailName);
        return template.queryForObject(sql, param, trailRowMapper());
    }

    private RowMapper<TrailDto> trailRowMapper() {
        return BeanPropertyRowMapper.newInstance(TrailDto.class);
    }
}
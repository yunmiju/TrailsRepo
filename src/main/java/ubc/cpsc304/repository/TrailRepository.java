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
import ubc.cpsc304.domain.TrailInfo;
import ubc.cpsc304.repository.DTO.TrailDto;

import java.util.List;

@Slf4j
public class TrailRepository {
    private final NamedParameterJdbcTemplate template;

    public TrailRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

//    public TrailDto trailInfoByParkIdAndTrailName(int parkId,
//                                                  String trailName) {
//        String sql =
//                "SELECT " +
//                        "parks.id, " +
//                        "trail_info.trail_name, " +
//                        "trail_info.difficulty, " +
//                        "trail_level.duration, " +
//                        "trail_info.distance, " +
//                        "trail_info.trail_description, " +
//                        "trail_image.image_url " +
//                        "FROM trail_info " +
//                        "LEFT JOIN trail_image img on trail_info.trail_name =" +
//                        " img.trail_name " +
//                        "LEFT JOIN trail_level lvl on trail_info.distance = " +
//                        "lvl.distance AND trail_info.difficulty = lvl" +
//                        ".difficulty " +
//                        "JOIN parks p on p.id = trail_info.park_id " +
//                        "WHERE park_id=:parkId AND trail_name=:trailName";
//        SqlParameterSource param = new MapSqlParameterSource()
//                .addValue("parkId", parkId)
//                .addValue("trailName", trailName);
//        return template.queryForObject(sql, param, trailRowMapper());
//    }

    public List<TrailDto> getByParkId(int parkId) {
        String sql =
                "SELECT " +
                        "p.id, " +
                        "trail_info.trail_name, " +
                        "trail_info.difficulty, " +
                        "lvl.duration, " +
                        "trail_info.distance, " +
                        "trail_info.trail_description, " +
                        "img.image_url " +
                        "FROM trail_info " +
                        "LEFT JOIN trail_image img on trail_info.trail_name =" +
                        " img.trail_name " +
                        "LEFT JOIN trail_level lvl on trail_info.distance = " +
                        "lvl.distance AND trail_info.difficulty = lvl" +
                        ".difficulty " +
                        "LEFT JOIN parks p on p.id = trail_info.park_id " +
                        "WHERE p.id=:parkId";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("parkId", parkId);
        return template.query(sql, param, trailRowMapper());
    }

    private RowMapper<TrailDto> trailRowMapper() {
        return BeanPropertyRowMapper.newInstance(TrailDto.class);
    }

    // TODO: EXCEPT command doesn't work (need to switch to NOT EXISTS)
    public List<TrailDto> divisionBySeason(int parkId, String seasonName) {
//        String sql =
//                "select t.trail_name from trail_season t join SEASONS s on t.season_name = s.season_name\n" +
//                        "where not exists ((select s2.season_name from " +
//                        "SEASONS s2 where s2.season_name=:seasonName)\n" +
//                        "minus (select s3.season_name from SEASONS s3 where " +
//                        "s3.season_name=t.season_name))";

        String sql =
                "SELECT t.trail_name " +
                        "FROM trail_info t " +
                        "WHERE NOT EXISTS (SELECT s.season_name " +
                        "FROM seasons s " +
                        "WHERE NOT EXISTS " +
                        "(SELECT ts.season_name " +
                        "FROM trail_season ts " +
                        "WHERE s.season_name = ts.season_name AND s" +
                        ".SEASON_NAME =: seasonName AND ts.park_id = t.park_id " +
                        "AND t.park_id =: parkId))";
//                        "on_name\n" +
//                        "where not exists ((select s2.season_name from " +
//                        "SEASONS s2 where s2.season_name=:seasonName)\n" +
//                        "minus (select s3.season_name from SEASONS s3 where " +
//                        "s3.season_name=t.season_name))";

//            "SELECT " +
//                "p.id, " +
//                "trail_info.trail_name, " +
//                "trail_info.difficulty, " +
//                "lvl.duration, " +
//                "trail_info.distance, " +
//                "trail_info.trail_description, " +
//                "img.image_url " +
//            "FROM trail_info " +
//            "LEFT JOIN trail_image img on trail_info.trail_name =" +
//                " img.trail_name " +
//            "LEFT JOIN trail_level lvl on trail_info.distance = " +
//                "lvl.distance AND trail_info.difficulty = lvl.difficulty " +
//            "LEFT JOIN parks p on p.id = trail_info.park_id " +
//            "WHERE NOT EXISTS " +
//                "((SELECT s.season_name " +
//                "FROM Seasons s)" +
//                "EXCEPT " +
//                    "(SELECT ts.season_name " +
//                    "FROM trail_season ts " +
//                    "WHERE ts.trail_name = trail_info.trail_name AND " +
//                    "ts.park_id = trail_info.park_id))";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("parkId", parkId)
                .addValue("seasonName", seasonName);
        return template.query(sql, trailRowMapper());
    }

    public TrailDto numOfHuts(String trailName, int parkId) {
        String sql =
                "SELECT count(*) " +
                        "FROM trail_info " +
                        "LEFT JOIN huts h on h.trail_name = trail_info.trail_name AND " +
                        "h.park_id = trail_info.park_id " +
                        "WHERE h.trail_name = trail_info.trail_name AND " +
                        "h.park_id = trail_info.park_id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("parkId", parkId)
                .addValue("trailName", trailName);
        return template.queryForObject(sql, param, trailRowMapper());
    }
}
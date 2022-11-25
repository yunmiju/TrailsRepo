package ubc.cpsc304.repository;

import java.util.List;
import java.lang.String;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
//import ubc.cpsc304.domain.TrailImage;
import ubc.cpsc304.domain.Seasons;
import ubc.cpsc304.domain.TrailLevel;
import ubc.cpsc304.domain.TrailSeason;
import ubc.cpsc304.domain.TrailInfo;
//import ubc.cpsc304.Mapper.TrailImageMapper;
import ubc.cpsc304.Mapper.TrailLevelMapper;
import ubc.cpsc304.Mapper.TrailSeasonMapper;
import ubc.cpsc304.Mapper.TrailInfoMapper;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class TrailRepository {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public TrailRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public List<TrailInfo> getByParkId(int parkId) {
        return jdbcTemplate.query("select * from TrailInfo where park_id = ?",
                new TrailInfoMapper());
    }

    public List<TrailInfo> getBySeason(Seasons season) {
        String sql = "select * from Trail_info ti, Trail_season ts " +
                "where ts.season_name = season";
        return jdbcTemplate.query(sql, new TrailInfoMapper());
    }

    public List<TrailInfo> getByHut() {
        String sql = "select * from Trail_info ti, Huts h group by trail_name " +
                "having COUNT(*) > 0";
        return jdbcTemplate.query(sql, new TrailInfoMapper());
    }
}

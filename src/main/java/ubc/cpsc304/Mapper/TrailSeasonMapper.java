package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.TrailSeason;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrailSeasonMapper implements RowMapper<TrailSeason> {

    @Override
    public TrailSeason mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrailSeason ts = new TrailSeason();
        ts.setTrailName(rs.getString("trail_name"));
        ts.setSeasonName(rs.getString("season_name"));
        ts.setParkId(rs.getInt("park_id"));
        ts.setDifficulty(rs.getString("difficulty"));
        return ts;
    }
}

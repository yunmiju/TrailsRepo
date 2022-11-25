package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.TrailInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrailInfoMapper implements RowMapper<TrailInfo> {

    @Override
    public TrailInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrailInfo ts = new TrailInfo();
        ts.setTrailName(rs.getString("trail_name"));
        ts.setParkId(rs.getInt("park_id"));
        ts.setDifficulty(rs.getString("difficulty"));
        ts.setDistance(rs.getFloat("distance"));
        ts.setTrailDescription(rs.getString("trail_description"));
        return ts;
    }
}

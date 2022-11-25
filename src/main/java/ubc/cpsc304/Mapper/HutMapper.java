package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Huts;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HutMapper implements RowMapper {
    @Override
    public Huts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Huts hut = new Huts();
        hut.setId(rs.getInt("id"));
        hut.setTrailName(rs.getString("trail_name"));
        hut.setParkId(rs.getInt("park_id"));
        hut.setDifficulty(rs.getString("difficulty"));
        hut.setBeds(rs.getInt("beds"));
        return hut;
    }
}

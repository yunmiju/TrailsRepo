package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Seasons;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeasonMapper implements RowMapper {
    @Override
    public Seasons mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seasons season = new Seasons();
        season.setSeasonName(rs.getString("season_name"));
        return season;
    }
}

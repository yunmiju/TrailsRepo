package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Park;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.PublicPark;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkCombineMapper implements RowMapper {

    @Override
    public ParkA mapRow(ResultSet rs, int rowNum) throws SQLException {
        ParkA park = new Park(rs.getInt("id"));
        park.setProvinceId(rs.getInt("province_id"));
        park.setParkName(rs.getString("park_name"));
        park.setParkAddress(rs.getString("park_address"));
        park.setOpenHour(rs.getString("open_hour"));
        park.setCloseHour(rs.getString("close_hour"));
        try {
            park.setPermitType(rs.getString("permit_type"));
            park.setDailyCapacity(rs.getInt("daily_capacity"));
            return park;
        } catch (SQLException e) {
            park.setCampingSite(rs.getBoolean("camping_site"));
            return park;
        }
    }
}

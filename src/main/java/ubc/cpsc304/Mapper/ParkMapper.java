package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Parks;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkMapper implements RowMapper {
    @Override
    public Parks mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parks park = new Parks();
        park.setId(rs.getInt("id"));
        park.setProvinceId(rs.getInt("province_id"));
        park.setParkName(rs.getString("park_name"));
        park.setParkAddress(rs.getString("park_address"));
        park.setOpenHour(rs.getString("open_hour"));
        park.setCloseHour(rs.getString("close_hour"));
        return park;
    }
}

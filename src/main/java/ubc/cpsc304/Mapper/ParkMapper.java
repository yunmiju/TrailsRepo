package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Park;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkMapper implements RowMapper {
    @Override
    public Park mapRow(ResultSet rs, int rowNum) throws SQLException {
        Park park = new Park();
        park.setId(rs.getInt("id"));
        park.setProvinceId(rs.getInt("province_id"));
        park.setParkName("park_name");
        park.setParkAddress("park_address");
        park.setOpenHour("open_hour");
        park.setCloseHour("close_hour");
        return park;
    }
}

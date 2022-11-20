package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.RestrictedPark;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestrictedParkCombineMapper implements RowMapper {
    @Override
    public RestrictedPark mapRow(ResultSet rs, int rowNum) throws SQLException {
        RestrictedPark park = new RestrictedPark(rs.getInt("id"));
        park.setDailyCapacity(rs.getInt("daily_capacity"));
        park.setPermitType(rs.getString("permit_type"));
        park.setProvinceId(rs.getInt("province_id"));
        park.setParkName(rs.getString("park_name"));
        park.setParkAddress(rs.getString("park_address"));
        park.setOpenHour(rs.getString("open_hour"));
        park.setCloseHour(rs.getString("close_hour"));
        return park;
    }
}

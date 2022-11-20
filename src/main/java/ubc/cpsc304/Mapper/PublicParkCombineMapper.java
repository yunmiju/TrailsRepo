package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.PublicPark;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicParkCombineMapper implements RowMapper {

    @Override
    public PublicPark mapRow(ResultSet rs, int rowNum) throws SQLException {
        PublicPark park = new PublicPark(rs.getInt("id"));
        park.setCampingSite(rs.getBoolean("camping_site"));
        park.setProvinceId(rs.getInt("province_id"));
        park.setParkName(rs.getString("park_name"));
        park.setParkAddress(rs.getString("park_address"));
        park.setOpenHour(rs.getString("open_hour"));
        park.setCloseHour(rs.getString("close_hour"));
        return park;
    }
}

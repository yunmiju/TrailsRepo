package ubc.cpsc304.Mapper;
import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Province;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceMapper implements RowMapper {

    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        Province province = new Province(rs.getInt("id"));
        province.setProvinceName(rs.getString("Province_name"));
        province.setCountryName(rs.getString("country_name"));
        return province;
    }
}

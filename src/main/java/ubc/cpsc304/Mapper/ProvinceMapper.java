package ubc.cpsc304.Mapper;
import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Provinces;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceMapper implements RowMapper {

    @Override
    public Provinces mapRow(ResultSet rs, int rowNum) throws SQLException {
        Provinces province = new Provinces(rs.getInt("id"));
        province.setProvinceName(rs.getString("Province_name"));
        province.setCountryName(rs.getString("country_name"));
        return province;
    }
}

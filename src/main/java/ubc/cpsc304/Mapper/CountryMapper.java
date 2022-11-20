package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Countries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper{
    @Override
    public Countries mapRow(ResultSet rs, int rowNum) throws SQLException {
        Countries countries = new Countries();
        countries.setCname(rs.getString("COUNTRY_NAME"));
        return countries;
    }
}

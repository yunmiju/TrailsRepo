package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper{
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setCname(rs.getString("COUNTRY_NAME"));
        return country;
    }
}

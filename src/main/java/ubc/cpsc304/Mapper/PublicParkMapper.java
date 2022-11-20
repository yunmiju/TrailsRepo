package ubc.cpsc304.Mapper;
import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.PublicPark;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicParkMapper implements RowMapper {
    @Override
    public PublicPark mapRow(ResultSet rs, int rowNum) throws SQLException {
        PublicPark park = new PublicPark(rs.getInt("id"));
        park.setCampingSite(rs.getBoolean("camping_site"));
        return park;
    }
}


package ubc.cpsc304.Mapper;

import org.springframework.jdbc.core.RowMapper;
import ubc.cpsc304.domain.VisitorCenter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitorCenterMapper implements RowMapper {


    @Override
    public VisitorCenter mapRow(ResultSet rs, int rowNum) throws SQLException {
        VisitorCenter visitorCenter = new VisitorCenter(rs.getInt("id"));
        visitorCenter.setParkId(rs.getInt("park_id"));
        visitorCenter.setCenterName(rs.getString("center_name"));
        visitorCenter.setEmail(rs.getString("email"));
        visitorCenter.setCenterAddress(rs.getString("center_address"));
        return visitorCenter;
    }
}

package ubc.cpsc304.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.ParkMapper;
import ubc.cpsc304.domain.Park;
import ubc.cpsc304.domain.TrailImage;

import javax.sql.DataSource;
import java.util.List;

public class TrailsImageRepositoryV1 {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public TrailsImageRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public List<String> getImagesByParkId(int parkId) {
        String sql = "select Image_url from TRAIL_IMAGE where park_id = ?";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getString("image_url"), parkId);
    }
}

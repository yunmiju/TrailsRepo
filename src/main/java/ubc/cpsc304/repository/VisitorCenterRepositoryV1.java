package ubc.cpsc304.repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.VisitorCenterMapper;
import ubc.cpsc304.domain.VisitorCenter;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
public class VisitorCenterRepositoryV1 {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public VisitorCenterRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addVisitorCenter(VisitorCenter v) {
        int count = 0;
        String query = "insert into Visitor_Center(id, park_id, center_name, email, center_address) values (?, ?, ?, ?, ?)";
        count = jdbcTemplate.update(query, v.getId(), v.getParkId(), v.getCenterName(), v.getEmail(), v.getCenterAddress());
        return count;
    }

    public VisitorCenter getById(int id) {
        return (VisitorCenter) jdbcTemplate.queryForObject("select * from Visitor_Center where id = ?", new VisitorCenterMapper(), id);
    }

    public VisitorCenter getByParkId(int parkId) {
        return (VisitorCenter) jdbcTemplate.queryForObject("select * from Visitor_Center where park_id = ?", new VisitorCenterMapper(), parkId);
    }

    public List<VisitorCenter> getAll() {
        String sql = "select * from Visitor_Center";
        return jdbcTemplate.query(sql, new VisitorCenterMapper());
    }
}

package ubc.cpsc304.repository;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.ParkCombineMapper;
import ubc.cpsc304.Mapper.ParkMapper;
import ubc.cpsc304.domain.Park;
import lombok.extern.slf4j.Slf4j;
import ubc.cpsc304.domain.ParkA;


@Slf4j
public class ParkRepositoryV1 {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public ParkRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addPark(Park p) {
        int count = 0;
        String query = "insert into Park(id, province_id, park_name, park_address, open_hour, close_hour) values (?, ?, ?, ?, ?, ?)";
        count = jdbcTemplate.update(query, p.getId(), p.getProvinceId(), p.getParkName(), p.getParkAddress(), p.getOpenHour(), p.getCloseHour());
        return count;
    }

    public Park getById(int id) {
        return (Park) jdbcTemplate.queryForObject("select * from Park where id = ?", new ParkMapper(), id);
    }

    public List<Park> getAll() {
        String sql = "select * from Park";
        return jdbcTemplate.query(sql, new ParkMapper());
    }

    public List<Park> getByProvinceId(int provinceId) {
        String sql = "select * from Park where province_id = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), provinceId);
    }

    public List<Park> getByName(String parkName) {
        String sql = "select * from Park where park_name = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), parkName);
    }

    public List<ParkA> getByOpenHour(String openHour) {
        String sql = "select * from Park where open_hour = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), openHour);
    }

    public List<ParkA> getByCloseHour(String closeHour) {
        String sql = "select * from Park where close_hour = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), closeHour);
    }

    public List<String> getProvinceProj() {
        String sql = "select DISTINCT province_name from Park INNER JOIN Province ON park.province_id = province.id";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("province_name")));
    }

    public List<String> getOpenHourProj() {
        String sql = "select DISTINCT open_hour from Park ORDER BY open_hour";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("open_hour")));
    }

    public List<String> getCloseHourProj() {
        String sql = "select DISTINCT close_hour from Park ORDER BY close_hour";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("close_hour")));
    }


    public List<ParkA> getByProvinceName(String provinceName) {
        String sql = "select * from Park WHERE province_id = (select id from Province where province_name = ?)";
        return jdbcTemplate.query(sql, new ParkMapper(), provinceName);
    }
}
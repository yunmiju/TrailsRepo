package ubc.cpsc304.repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.ParkMapper;
import lombok.extern.slf4j.Slf4j;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.Parks;


@Slf4j
public class ParkRepositoryV1 {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public ParkRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addPark(Parks p) {
        int count = 0;
        String query = "insert into Parks(id, province_id, park_name, park_address, open_hour, close_hour) values (?, ?, ?, ?, ?, ?)";
        count = jdbcTemplate.update(query, p.getId(), p.getProvinceId(), p.getParkName(), p.getParkAddress(), p.getOpenHour(), p.getCloseHour());
        return count;
    }

    public Parks getById(int id) {
        return (Parks) jdbcTemplate.queryForObject("select * from Parks where id = ?", new ParkMapper(), id);
    }

    public List<Parks> getAll() {
        String sql = "select * from Parks";
        return jdbcTemplate.query(sql, new ParkMapper());
    }

    public List<ParkA> getByProvinceId(int provinceId) {
        String sql = "select * from Parks where province_id = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), provinceId);
    }

    public List<Parks> getByName(String parkName) {
        String sql = "select * from Parks where park_name = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), parkName);
    }

    public List<ParkA> getByOpenHour(String openHour) {
        String sql = "select * from Parks where open_hour = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), openHour);
    }

    public int getByOpenHourAgg(String openHour) {
        String sql = "select COUNT(*) from Parks " +
                "GROUP BY open_hour " +
                "HAVING open_hour = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, openHour);
    }

    public List<ParkA> getByCloseHour(String closeHour) {
        String sql = "select * from Parks where close_hour = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), closeHour);
    }

    public int getByCloseHourAgg(String closeHour) {
        String sql = "select COUNT(close_hour) from Parks " +
                "where close_hour = ? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, closeHour);
    }

    public List<Integer> getProvinceIdProj() {
        String sql = "select DISTINCT province_id from Parks";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getInt("province_id"));
    }

    public List<String> getProvinceProj() {
        String sql = "select DISTINCT province_name from Parks INNER JOIN Provinces ON parks.province_id = provinces.id";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("province_name")));
    }

    public List<String> getOpenHourProj() {
        String sql = "select DISTINCT open_hour from Parks ORDER BY open_hour";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("open_hour")));
    }

    public List<String> getCloseHourProj() {
        String sql = "select DISTINCT close_hour from Parks ORDER BY close_hour";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(rs.getString("close_hour")));
    }


    public List<ParkA> getByProvinceName(String provinceName) {
        String sql = "select * from Parks WHERE province_id = (select id from Provinces where province_name = ?)";
        return jdbcTemplate.query(sql, new ParkMapper(), provinceName);
    }

    public int getByProvinceNameAgg(String provinceName) {
        String sql = "select COUNT(*) from Parks " +
                "WHERE province_id = (select id from Provinces where province_name = ?)";

        return jdbcTemplate.queryForObject(sql, Integer.class, provinceName);
    }

    public int getCountByProvinceId(int provinceId) {
        String sql = "select COUNT(*) from Parks " +
                "Where province_id = ? " +
                "GROUP BY province_id ";
        return jdbcTemplate.queryForObject(sql, Integer.class, provinceId);
    }


    public List<ParkA> getByCountry(String countryName) {
        String sql = "select P.id, P.province_id, P.park_name, P.park_address, P.open_hour, P.close_hour " +
                "from Parks P " +
                "INNER JOIN Provinces PR On P.province_id = PR.id " +
                "where PR.country_name = ?";
        return jdbcTemplate.query(sql, new ParkMapper(), countryName);
    }
}
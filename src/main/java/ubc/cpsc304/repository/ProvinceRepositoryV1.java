package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.ProvinceMapper;
import ubc.cpsc304.domain.Provinces;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Slf4j
public class ProvinceRepositoryV1 {
    protected final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public ProvinceRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addProvince(Provinces p) throws SQLException {
        String query = "insert into Provinces(id, province_name, country_name) values (?, ?, ?)";
        return jdbcTemplate.update(query, p.getId(), p.getProvinceName(), p.getCountryName());
    }

    public Provinces getById(int id) {
        return (Provinces) jdbcTemplate.queryForObject("select * from Provinces where id = ?", new ProvinceMapper(), id);
    }

    public List<Provinces> getAll() {
        String sql = "select * from Provinces";
        return jdbcTemplate.query(sql, new ProvinceMapper());
    }

    public List<Provinces> getByProvinceName(String provinceName) {
        String sql = "select * from Provinces where province_name = ?";
        return jdbcTemplate.query(sql, new ProvinceMapper(), provinceName);
    }

    public String getProvinceName(int provinceId) {
        String sql = "select province_name from Provinces WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getString("province_name"), provinceId);
    }

    public String getCountryName(int provinceId) {
        String sql = "select country_name from Provinces WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getString("country_name"), provinceId);
    }

    public List<Provinces> getByCountry(String countryName) {
        String sql = "select * from Provinces where country_name = ?";
        return jdbcTemplate.query(sql, new ProvinceMapper());
    }
}

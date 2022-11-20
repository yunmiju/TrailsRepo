package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.ProvinceMapper;
import ubc.cpsc304.domain.Province;

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

    public int addProvince(Province p) throws SQLException {
        String query = "insert into Province(id, province_name, country_name) values (?, ?, ?)";
        return jdbcTemplate.update(query, p.getId(), p.getProvinceName(), p.getCountryName());
    }

    public Province getById(int id) {
        return (Province) jdbcTemplate.queryForObject("select * from Province where id = ?", new ProvinceMapper(), id);
    }

    public List<Province> getAll() {
        String sql = "select * from Province";
        return jdbcTemplate.query(sql, new ProvinceMapper());
    }

    public List<Province> getByName(String provinceName) {
        String sql = "select * from Province where province_name = ?";
        return jdbcTemplate.query(sql, new ProvinceMapper(), provinceName);
    }


    public List<Province> getByCountry(String countryName) {
        String sql = "select * from Province where country_name = ?";
        return jdbcTemplate.query(sql, new ProvinceMapper());
    }
}

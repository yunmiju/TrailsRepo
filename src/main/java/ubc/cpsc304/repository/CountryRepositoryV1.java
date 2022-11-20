package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.CountryMapper;
import ubc.cpsc304.domain.Countries;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
public class CountryRepositoryV1 {
    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public CountryRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addCountry(Countries countries) {
        int count = 0;
        String query = "insert into Countries values (?)";
        count = jdbcTemplate.update(query, countries.getCname());
        return count;
    }

    public List<Countries> getAll() {
        String sql = "select * from Countries";
        @SuppressWarnings("unchecked")
        List<Countries> countryList = jdbcTemplate.query(sql, new CountryMapper());
        return countryList;
    }

    public Countries getByName(String cname) {
        return (Countries) jdbcTemplate.queryForObject("SELECT * FROM Countries WHERE COUNTRY_NAME = ?", new CountryMapper(), cname);
    }

}

package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ubc.cpsc304.Mapper.CountryMapper;
import ubc.cpsc304.domain.Country;

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

    public int addCountry(Country country) {
        int count = 0;
        String query = "insert into Country values (?)";
        count = jdbcTemplate.update(query, country.getCname());
        return count;
    }

    public List<Country> getAll() {
        String sql = "select * from Country";
        @SuppressWarnings("unchecked")
        List<Country> countryList = jdbcTemplate.query(sql, new CountryMapper());
        return countryList;
    }

    public Country getByName(String cname) {
        return (Country) jdbcTemplate.queryForObject("SELECT * FROM Country WHERE COUNTRY_NAME = ?", new CountryMapper(), cname);
    }
}

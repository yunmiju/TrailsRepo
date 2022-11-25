package ubc.cpsc304.repository;
import javax.sql.DataSource;

import ubc.cpsc304.Mapper.ParkCombineMapper;
import ubc.cpsc304.Mapper.RestrictedParkMapper;
import ubc.cpsc304.domain.Parks;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.RestrictedPark;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RestrictedParkRepositoryV1 extends ParkRepositoryV1{

    public RestrictedParkRepositoryV1(DataSource dataSource) {
        super(dataSource);
    }

    public int addPark(RestrictedPark p) {
        int count = 0;
        String query = "insert into Restricted_Park(id, daily_capacity, permit_type) values (?, ?, ?)";
        count = jdbcTemplate.update(query, p.getId(), p.getDailyCapacity(), p.getPermitType());
        return count;
    }

    public RestrictedPark getById(int id) {
        return (RestrictedPark) jdbcTemplate.queryForObject("select * from Restricted_park where id = ?", new RestrictedParkMapper(), id);
    }

    public List<Parks> getAll() {
        String sql = "select * from Restricted_park";
        return jdbcTemplate.query(sql, new RestrictedParkMapper());
    }

    public List<ParkA> getCombinedPark() {
        String sql = "select * from Parks INNER JOIN restricted_park ON parks.id = restricted_park.id";
//        return jdbcTemplate.query(sql, new RestrictedParkCombineMapper());
        return jdbcTemplate.query(sql, new ParkCombineMapper());
    }


    public List<RestrictedPark> getByPermitType(String permitType){
        String sql = "select * from Restricted_park where permit_type = ?";
        return jdbcTemplate.query(sql, new RestrictedParkMapper(), permitType);
    }


    public List<String> getPermitTypeProj() {
        String sql = "select DISTINCT permit_type from Restricted_park ORDER BY permit_type";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getString("permit_type"));
    }

    public List<ParkA> getByProvinceNameProj(String provinceName) {
        String sql = "select * from Parks INNER JOIN restricted_park ON parks.id = restricted_park.id WHERE province_id = (select id from Provinces where province_name = ?) ";
        return jdbcTemplate.query(sql, new ParkCombineMapper(), provinceName);
    }


    public List<RestrictedPark> getByPermitTypeComb(String permitType){
        String sql = "select * " +
                "from Restricted_park R INNER JOIN Parks P ON P.id = R.id " +
                "where R.PERMIT_TYPE = ?";
        return jdbcTemplate.query(sql, new ParkCombineMapper(), permitType);
    }

    public int getByPermitTypeCombAgg(String permitType){
        String sql = "select COUNT(*) " +
                "from Restricted_park R INNER JOIN Parks P ON P.id = R.id " +
                "GROUP BY R.PERMIT_TYPE " +
                "HAVING R.PERMIT_TYPE = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, permitType);
    }
}

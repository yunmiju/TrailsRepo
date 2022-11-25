package ubc.cpsc304.repository;
import javax.sql.DataSource;

import ubc.cpsc304.Mapper.ParkCombineMapper;
import ubc.cpsc304.Mapper.PublicParkMapper;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.domain.Parks;
import ubc.cpsc304.domain.PublicPark;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PublicParkRepositoryV1 extends ParkRepositoryV1{

    public PublicParkRepositoryV1(DataSource dataSource) {
        super(dataSource);
    }

    public int addPark(PublicPark p) {
        int count = 0;
        String query = "insert into Public_park(id, camping_site) values (?, ?)";
        count = jdbcTemplate.update(query, p.getId(), p.isCampingSite());
        return count;
    }

    public PublicPark getById(int id) {
        return (PublicPark) jdbcTemplate.queryForObject("select * from Public_park WHERE id = ?", new PublicParkMapper(), id);
    }

    public List<Parks> getAll() {
        String sql = "select * from Public_park";
        return jdbcTemplate.query(sql, new PublicParkMapper());
    }

    public List<ParkA> getCombinedPark() {
        String sql = "select * from Parks INNER JOIN public_park ON parks.id = public_park.id";
        return jdbcTemplate.query(sql, new ParkCombineMapper());
    }

    public List<PublicPark> getByCampingSite(boolean campingSite){
        String sql = "select * from Public_park where camping_site = ?";
        return jdbcTemplate.query(sql, new PublicParkMapper(), campingSite);
    }

    public List<PublicPark> getByCampingSiteComb(boolean campingSite){
        String sql = "select * from Public_park PU INNER JOIN Parks P ON PU.ID = P.ID " +
                "where PU.CAMPING_SITE = ?";
        return jdbcTemplate.query(sql, new ParkCombineMapper(), campingSite);
    }

    public int getByCampingSiteCombAgg(boolean campingSite){
        String sql = "select COUNT(*) " +
                "from Public_park PU " +
                "INNER JOIN Parks P ON PU.ID = P.ID " +
                "GROUP BY PU.camping_site "+
                "HAVING PU.camping_site = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, campingSite);
    }

    public List<String> getCampingSiteProj() {
        String sql = "select DISTINCT camping_site from Public_park ORDER BY camping_site";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new String(String.valueOf(rs.getBoolean("camping_site"))));
    }

    public List<ParkA> getByProvinceNameProj(String provinceName) {
        String sql = "select * from Parks INNER JOIN Public_park ON parks.id = public_park.id WHERE province_id = (select id from Provinces where province_name = ?)";
        return jdbcTemplate.query(sql, new ParkCombineMapper(), provinceName);
    }
}

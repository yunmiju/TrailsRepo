package ubc.cpsc304.repository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ubc.cpsc304.domain.Province;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class ProvinceRepositoryV1Test {

    ProvinceRepositoryV1 provinceRepositoryV1;

    @BeforeEach
    void beforeEach() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl(ORACLE_URL);
//        dataSource.setUsername(USER_NAME);
//        dataSource.setPassword(PASSWORD);
//        dataSource.setMaximumPoolSize(3);
//        dataSource.setPoolName("MyPool");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);
        provinceRepositoryV1 = new ProvinceRepositoryV1(dataSource);
    }

    @Test
    void curdAdd() throws SQLException {
//        Province p1 = new Province(11, "BC", "CANADA");
//        int rst = provinceRepositoryV1.addProvince(p1);
//        assertThat(rst).isEqualTo(1);
//        Province p2 = new Province(21, "CA", "US");
//        int rst = provinceRepositoryV1.addProvince(p2);
//        assertThat(rst).isEqualTo(1);
//        Province p3 = new Province(12, "AB", "CANADA");
//        int rst = provinceRepositoryV1.addProvince(p3);
//        assertThat(rst).isEqualTo(1);
//        Province p4 = new Province(13, "ON", "CANADA");
//        int rst = provinceRepositoryV1.addProvince(p4);
//        assertThat(rst).isEqualTo(1);
//        Province p5 = new Province(14, "QC","CANADA");
//        int rst = provinceRepositoryV1.addProvince(p5);
//        assertThat(rst).isEqualTo(1);
    }

    @Test
    void curdGet() throws SQLException {
        List<Province> findProvince = provinceRepositoryV1.getAll();
        log.info("findProvince = {}", findProvince);
        assertThat(findProvince.size()).isEqualTo(5);
//        Province p1 = new Province(11, "BC", "CANADA");
//
//        List<Province> findProvinceByName = provinceRepositoryV1.getByName("CANADA");
//        log.info("findProvinceByName = {}", findProvinceByName);
//        assertThat(findProvinceByName.size()).isEqualTo(4);
//        System.out.println(findProvinceByName);
    }

}


package ubc.cpsc304.repository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubc.cpsc304.domain.Parks;
import ubc.cpsc304.domain.ParkA;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ubc.cpsc304.database.ConnectionConst.*;


@Slf4j
public class ParkRepositoryV1Test {
    ParkRepositoryV1 parkRepositoryV1;

    @BeforeEach
    void beforeEach(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(ORACLE_URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");
        parkRepositoryV1 = new ParkRepositoryV1(dataSource);
    }

//    @Test
//    void curdAdd() throws SQLException {
//        Park p1 = new Park(104, 11, "Beaver Creek Provincial Park", "8801 BC-22A, Trail, BC V1R 4W6", "07", "17");
//        int rst = parkRepositoryV1.addPark(p1);
//        assertThat(rst).isEqualTo(1);
//        Park p2 = new Park(105, 11, "Cedar Point Provincial Park", "Cariboo F, BC V0L 1N0", "08", "16");
//        rst = parkRepositoryV1.addPark(p2);
//        assertThat(rst).isEqualTo(1);
//        Park p3 = new Park(106, 11, "Ferry Island Provincial Park", "Fraser Valley, BC V0X 1X0", "07", "18");
//        rst = parkRepositoryV1.addPark(p3);
//        assertThat(rst).isEqualTo(1);
//        Park p4 = new Park(203, 21, "Caspar Headlands State Natural Reserve", "14260 Headlands Dr, Mendocino, CA 95460, United States",
//                "10", "17");
//        rst = parkRepositoryV1.addPark(p4);
//        assertThat(rst).isEqualTo(1);
//        Park p5 = new Park(107, 11, "Gibson River Provincial Park", "S Gibson Lake Rd, Severn, ON L0K 1S0", "06", "16");
//        rst = parkRepositoryV1.addPark(p5);
//        assertThat(rst).isEqualTo(1);
//    }

//    @Test
//    void curdGet() throws SQLException {
//        List<Park> findPark = parkRepositoryV1.getAll();
//        log.info("findPark = {}", findPark);
//        assertThat(findPark.size()).isEqualTo(10);
//        List<Park> findParkByProvinceId = parkRepositoryV1.getByProvinceId(11);
//        log.info("findParkByProvinceId = {}", findParkByProvinceId);
//        assertThat(findParkByProvinceId.size()).isEqualTo(7);
//        System.out.println(findParkByProvinceId);
//    }

    @Test
    void curdProj() throws SQLException {
//        List<String> s = parkRepositoryV1.getProvinceProj();
//        System.out.println(s);
//        List<String> s2 = parkRepositoryV1.getOpenHourProj();
//        System.out.println(s2);
        int s3 = parkRepositoryV1.getCountByProvinceId(11);
        System.out.println(s3);
    }
}

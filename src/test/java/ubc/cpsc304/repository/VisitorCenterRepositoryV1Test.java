package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ubc.cpsc304.domain.VisitorCenter;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
//import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class VisitorCenterRepositoryV1Test {
//    VisitorCenterRepositoryV1 visitorCenterRepositoryV1;
//    @BeforeEach
//    void beforeEach(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);
//        visitorCenterRepositoryV1 = new VisitorCenterRepositoryV1(dataSource);
//    }
//
//    @Test
//    void curdAdd() throws SQLException {
//        VisitorCenter v1 = new VisitorCenter(1001, 101, "Strathcona Wilderness Institute", "strathconawilderness@gmail.com", "Courtenay, British Columbia V9N 5N5");
//        int rst = visitorCenterRepositoryV1.addVisitorCenter(v1);
//        assertThat(rst).isEqualTo(1);
//        VisitorCenter v2 = new VisitorCenter(1002, 102, "Cypress Provincial Park visitor center", "contact@cypressmountain.com",
//                "West Vancouver, BC V0N 1G0");
//        rst = visitorCenterRepositoryV1.addVisitorCenter(v2);
//        assertThat(rst).isEqualTo(1);
//        VisitorCenter v3 = new VisitorCenter(1004, 104, "Beaver Creek Institute", "beavercreekp@gmail.com", "8801 BC-22A, Trail, BC V1R 4W6 CANADA");
//        rst = visitorCenterRepositoryV1.addVisitorCenter(v3);
//        assertThat(rst).isEqualTo(1);
//        VisitorCenter v4 = new VisitorCenter(2001, 201, "Death Valley National Park Visitor Center", "deathvalleyvs@gmail.com",
//                "P.O. Box 579 Death Valley CA 92328 US");
//        rst = visitorCenterRepositoryV1.addVisitorCenter(v4);
//        assertThat(rst).isEqualTo(1);
//        VisitorCenter v5 = new VisitorCenter(2003, 203, "Caspar Headlands State Natural Reserve Visitor Center", "casparheadlandsmanage@gmail.com",
//                "14261 Headlands Dr Mendocino, CA 95460 US");
//        rst = visitorCenterRepositoryV1.addVisitorCenter(v5);
//        assertThat(rst).isEqualTo(1);
//    }
//
//    @Test
//    void curdGet() throws SQLException {
//        List<VisitorCenter> findVisitorCenter = visitorCenterRepositoryV1.getAll();
//        log.info("findVisitorCenter = {}", findVisitorCenter);
//        assertThat(findVisitorCenter.size()).isEqualTo(5);
//    }
}

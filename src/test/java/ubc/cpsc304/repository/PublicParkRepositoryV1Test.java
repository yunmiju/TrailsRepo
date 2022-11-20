package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ubc.cpsc304.domain.ParkA;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class PublicParkRepositoryV1Test {
//    PublicParkRepositoryV1 publicParkRepositoryV1;
//
//    @BeforeEach
//    void beforeEach(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);
//        publicParkRepositoryV1 = new PublicParkRepositoryV1(dataSource);
//    }
//
//    @Test
//    void curdAdd() throws SQLException {
//        PublicPark p1 = new PublicPark(101, true);
//        int rst = publicParkRepositoryV1.addPark(p1);
//        assertThat(rst).isEqualTo(1);
//        PublicPark p2 = new PublicPark(102, true);
//        rst = publicParkRepositoryV1.addPark(p2);
//        assertThat(rst).isEqualTo(1);
//        PublicPark p3 = new PublicPark(103, true);
//        rst = publicParkRepositoryV1.addPark(p3);
//        assertThat(rst).isEqualTo(1);
//        PublicPark p4 = new PublicPark(201, false);
//        rst = publicParkRepositoryV1.addPark(p4);
//        assertThat(rst).isEqualTo(1);
//        PublicPark p5 = new PublicPark(202, false);
//        int rst = publicParkRepositoryV1.addPark(p5);
//        assertThat(rst).isEqualTo(1);
//        PublicPark p6 = new PublicPark(203, true);
//        rst = publicParkRepositoryV1.addPark(p6);
//        assertThat(rst).isEqualTo(1);
//    }

//    @Test
//    void curdGet() throws SQLException {
//        List<Park> findPark = publicParkRepositoryV1.getAll();
//        log.info("findPark = {}", findPark);
//        assertThat(findPark.size()).isEqualTo(6);
//        List<PublicPark> findParkByCampingSite = publicParkRepositoryV1.getByCampingSite(false);
//        log.info("findParkByCampingSite = {}", findParkByCampingSite);
//        assertThat(findParkByCampingSite.size()).isEqualTo(2);
//        System.out.println(findParkByCampingSite);
//        List<ParkA> combinedPark = publicParkRepositoryV1.getCombinedPark();
//        log.info("combinedPark = {}", combinedPark);
//        System.out.println(combinedPark);
//        assertThat(combinedPark.size()).isEqualTo(6);
//    }
//
//    @Test
//    void curdProj() throws SQLException {
//        List<String> s = publicParkRepositoryV1.getCampingSiteProj();
//        System.out.println(s);
//    }

}

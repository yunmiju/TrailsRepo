package ubc.cpsc304.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ubc.cpsc304.domain.ParkA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ubc.cpsc304.database.ConnectionConst.*;

@Slf4j
public class RestrictedParkRepositoryV1Test {
    RestrictedParkRepositoryV1 restrictedParkRepositoryV1;

    @BeforeEach
    void beforeEach() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(ORACLE_URL, USER_NAME, PASSWORD);
        restrictedParkRepositoryV1 = new RestrictedParkRepositoryV1(dataSource);
    }

    @Test
    void curdAdd() throws SQLException {
//        RestrictedPark p1 = new RestrictedPark(104, 80, "A");
//        int rst = restrictedParkRepositoryV1.addPark(p1);
//        assertThat(rst).isEqualTo(1);
//        RestrictedPark p2 = new RestrictedPark(105, 120, "A");
//        rst = restrictedParkRepositoryV1.addPark(p2);
//        assertThat(rst).isEqualTo(1);
//        RestrictedPark p3 = new RestrictedPark(106, 60, "B");
//        rst = restrictedParkRepositoryV1.addPark(p3);
//        assertThat(rst).isEqualTo(1);
//        RestrictedPark p4 = new RestrictedPark(203, 80, "B");
//        rst = restrictedParkRepositoryV1.addPark(p4);
//        assertThat(rst).isEqualTo(1);
//        RestrictedPark p5 = new RestrictedPark(107, 100, "A");
//        rst = restrictedParkRepositoryV1.addPark(p5);
//        assertThat(rst).isEqualTo(1);

    }


    @Test
    void curdGet() throws SQLException {
//        List<Park> findPark = restrictedParkRepositoryV1.getAll();
//        log.info("findPark = {}", findPark);
//        assertThat(findPark.size()).isEqualTo(5);
//        List<RestrictedPark> findParkByPermitType = restrictedParkRepositoryV1.getByPermitType("A");
//        log.info("findParkByPermitType = {}", findParkByPermitType);
//        assertThat(findParkByPermitType.size()).isEqualTo(3);
//        System.out.println(findParkByPermitType);
//        List<ParkA> combinedPark = new ArrayList<>();
//        List<RestrictedPark> combinedPark = restrictedParkRepositoryV1.getCombinedPark();
//        combinedPark.addAll(restrictedParkRepositoryV1.getCombinedPark());
//        System.out.println(combinedPark);
//        System.out.println(combinedPark.size());
    }

    @Test
    void curdProj() throws SQLException {
//        List<String> s = restrictedParkRepositoryV1.getPermitTypeProj();
//        System.out.println(s);
//        List<ParkA> s4 = restrictedParkRepositoryV1.getByProvinceNameProj("BC");
//        System.out.println(s4.get(0).getPermitType());
//        System.out.println(s4);

//        int test = restrictedParkRepositoryV1.getByPermitTypeCombAgg("B");
//        System.out.println(test);
    }


}

//package ubc.cpsc304.repository;
//
//import java.util.Optional;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import ubc.cpsc304.repository.DTO.TrailDto;
//import ubc.cpsc304.repository.TrailRepository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@Slf4j
//@Transactional
//@SpringBootTest
//class TrailRepositoryTest {
//    @Autowired
//    TrailRepository trailRepository;
//
//    @Test
//    void getByParkId() {
//        trailRepository.getByParkId(101);
//    }
//}

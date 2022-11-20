package ubc.cpsc304.repository;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class ProgramRepositoryTest {

//  @Autowired
//  ProgramRepository programRepository;
//
//  @Test
//  void save() {
//    ProgramInfo programInfo = new ProgramInfo(6, 1002, "Explore the wild", 10);
//    ProgramInfo savedProgramInfo = programRepository.save(programInfo);
//
//    Optional<ProgramInfo> findProgramInfo = programRepository.findById(savedProgramInfo.getId());
//    assertThat(findProgramInfo).isEqualTo(savedProgramInfo);
//  }
//
//  @Test
//  void findAll() {
//    Program program = new Program();
//    List<Program> programs = programRepository.findAll();
//    System.out.println(programs);
//  }
//
//  @Test
//  void findByParkId() {
//    //findById
//    List<Program> findPrograms = programRepository.findByParkId(102);
//    log.info("findProgram={}", findPrograms);
//    assertThat(findPrograms).isNotNull();
//  }
//
//  @Test
//  void findById() {
//    //findById
//    Optional<ProgramInfo> findProgram = programRepository.findById(1);
//    System.out.println("findProgram= " + findProgram);
//    assertThat(findProgram).isNotNull();
//  }
}
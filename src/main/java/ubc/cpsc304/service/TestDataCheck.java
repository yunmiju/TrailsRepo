package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ubc.cpsc304.repository.ProgramRepository;

@Slf4j
@RequiredArgsConstructor
public class TestDataCheck {

  private final ProgramRepository programRepository;

  /**
   * 확인용 초기 데이터 추가
   */
  @EventListener(ApplicationReadyEvent.class)
  public void checkData() {
    log.info("test data check");
    programRepository.findAll();
  }
}

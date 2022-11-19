package ubc.cpsc304.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.repository.ProgramRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramServiceV2 implements ProgramService{
    private final ProgramRepository programRepository;

    public List<Program> findByParkId(int parkId) {
        return programRepository.findByParkId(parkId);
    }

    public List<Program> findAll() {
        return programRepository.findAll();
    }
}

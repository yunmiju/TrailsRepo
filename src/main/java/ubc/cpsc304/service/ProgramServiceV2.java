package ubc.cpsc304.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.domain.Program;
import ubc.cpsc304.domain.ProgramInfo;
import ubc.cpsc304.repository.ProgramRepository;
import ubc.cpsc304.repository.ProgramRepositoryV2;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramServiceV2 implements ProgramService {

    private final ProgramRepository programRepository;
    @Override
    public List<Program> findByParkId(long parkId) {

        return programRepository.findByParkId(parkId);
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<ProgramInfo> findById(int id) {
        return programRepository.findById(id);
    }
}
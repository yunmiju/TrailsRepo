package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ubc.cpsc304.domain.Program;

import java.util.List;
import java.util.Optional;
import ubc.cpsc304.domain.ProgramInfo;

public interface ProgramService {
    List<Program> findByParkId(long parkId);
    List<Program> findAll();

    Optional<ProgramInfo> findById(int id);
}

package ubc.cpsc304.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ubc.cpsc304.domain.Program;
import ubc.cpsc304.repository.ProgramRepository;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramService {
    private final ProgramRepository programRepository;

    public List<Program> findByParkId(int parkId) {
        return programRepository.findByParkId(parkId);
    }

    public List<Program> findAll() {
        return programRepository.findAll();
    }
}

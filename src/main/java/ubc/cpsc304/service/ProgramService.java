package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ubc.cpsc304.domain.Program;

import java.util.List;
import java.util.Optional;

public interface  ProgramService {
    List<Program> findByParkId(int parkId);
    List<Program> findAll();
}

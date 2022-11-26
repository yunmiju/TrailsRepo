package ubc.cpsc304.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubc.cpsc304.advice.ApiException;
import ubc.cpsc304.advice.ExceptionEnum;

//import ubc.cpsc304.domain.Seasons;
//import ubc.cpsc304.domain.TrailInfo;
import ubc.cpsc304.repository.DTO.TrailDto;
import ubc.cpsc304.repository.TrailRepository;
import ubc.cpsc304.repository.TrailsImageRepositoryV1;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrailServiceV2 implements TrailService {
    private final TrailRepository trailRepository;

//    public TrailServiceV2(DataSource dataSource) {
//        trailRepository = new TrailRepository(dataSource);
//    }

    @Override
    public List<TrailDto> getAllTrails(int parkId) {
        try {
            List<TrailDto> trails = new ArrayList<>();
            trails.addAll(trailRepository.getByParkId(parkId));
            return trails;
        } catch (DataAccessException e) {
            throw new ApiException(ExceptionEnum.EMPTY_RESULT);
        }
    }

    // TODO: divisionBySeason() from TrailRepository is itself not working!
    public List<TrailDto> trailsDivision(int parkId, String seasonName) {
        try {
            List<TrailDto> trails = new ArrayList<>();
            trails.addAll(trailRepository.divisionBySeason(parkId, seasonName));
            return trails;
        } catch (DataAccessException e) {
            throw new ApiException(ExceptionEnum.EMPTY_RESULT);
        }
    }

    // TODO:
    public boolean hasHuts(String trailName, int parkId) {
        try {
            TrailDto trail;
            trail = trailRepository.numOfHuts(trailName, parkId);
            return trail != null;
        } catch (DataAccessException e) {
            throw new ApiException(ExceptionEnum.EMPTY_RESULT);
        }
    }
}

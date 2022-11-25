package ubc.cpsc304.service;

import ubc.cpsc304.domain.Seasons;
import ubc.cpsc304.domain.TrailInfo;
import ubc.cpsc304.repository.TrailRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class TrailService {
    private TrailRepository trailRepository;

    public TrailService(DataSource dataSource) {
        trailRepository = new TrailRepository(dataSource);
    }

    public List<TrailInfo> getAllTrails(int parkId) {
        List<TrailInfo> trails = new ArrayList<>();
        trails.addAll(trailRepository.getByParkId(parkId));
        return trails;
    }
}

package ubc.cpsc304.service;

import ubc.cpsc304.repository.TrailRepository;
import ubc.cpsc304.repository.TrailsImageRepositoryV1;

import javax.sql.DataSource;
import java.util.List;

public class TrailImageService {
    private TrailsImageRepositoryV1 trailsImageRepository;

    public TrailImageService(DataSource dataSource) {
        trailsImageRepository = new TrailsImageRepositoryV1(dataSource);
    }

    public List<String> getImages(int parkId, String trailName) {
        return trailsImageRepository.getImagesByTrail(trailName, parkId);
    }
}

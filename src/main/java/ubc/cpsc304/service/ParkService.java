package ubc.cpsc304.service;
import ubc.cpsc304.domain.ParkA;
import ubc.cpsc304.repository.ParkRepositoryV1;
import ubc.cpsc304.repository.PublicParkRepositoryV1;
import ubc.cpsc304.repository.RestrictedParkRepositoryV1;
import ubc.cpsc304.repository.TrailsImageRepositoryV1;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;

public class ParkService {
    private ParkRepositoryV1 parkRepo;
    private RestrictedParkRepositoryV1 restrictParkRepo;
    private PublicParkRepositoryV1 publicParkRepo;
    private TrailsImageRepositoryV1 trailsImageRepositoryV1;

    public ParkService(DataSource dataSource) {
        parkRepo = new ParkRepositoryV1(dataSource);
        restrictParkRepo = new RestrictedParkRepositoryV1(dataSource);
        publicParkRepo = new PublicParkRepositoryV1(dataSource);
        trailsImageRepositoryV1 = new TrailsImageRepositoryV1(dataSource);
    }

    public List<ParkA> getAllParks() {
        List<ParkA> parks = new ArrayList<>();
        parks.addAll(publicParkRepo.getCombinedPark());
        parks.addAll(restrictParkRepo.getCombinedPark());
        return parks;
    }

    public List<String> getMainFilter() {
        List<String> mainFilter = new ArrayList<>();
        mainFilter.add("RESTRICTED_PARK");
        mainFilter.add("PUBLIC_PARK");
        mainFilter.add("PROVINCE");
        mainFilter.add("OPENHOUR");
        mainFilter.add("CLOSEHOUR");
        return mainFilter;
    }

    public List<String> getSecondFilter(String filter) {
        List<String> secondList = new ArrayList<>();
        if(filter.equals("RESTRICTED_PARK")) {
            return restrictParkRepo.getPermitTypeProj();
        } else if (filter.equals("PUBLIC_PARK")) {
            return publicParkRepo.getCampingSiteProj();
        } else if (filter.equals("PROVINCE")) {
            //join & proj
            return parkRepo.getProvinceProj();
        } else if (filter.equals("OPENHOUR")) {
            return parkRepo.getOpenHourProj();
        } else{
            return parkRepo.getCloseHourProj();
        }
    }

    public List<ParkA> getParksByFilter(String f1, String f2) {
        List<ParkA> filtered = new ArrayList<>();
        if(f1.equals("RESTRICTED_PARK")) {
            filtered.addAll(restrictParkRepo.getByPermitTypeComb(f2));
            return filtered;
        } else if (f1.equals("PUBLIC_PARK")){
            filtered.addAll(publicParkRepo.getByCampingSiteComb(Boolean.parseBoolean(f2)));
            return filtered;
        } else if (f1.equals("PROVINCE")) {
            //join & proj - from CombineMANAGER
//            return combineParksByProvinceName(f2);
            //from Park
            return parkRepo.getByProvinceName(f2);
        } else if (f1.equals("OPENHOUR")) {
            return parkRepo.getByOpenHour(f2);
        } else{
            return parkRepo.getByCloseHour(f2);
        }
    }

    public List<ParkA> combineParksByProvinceName(String provinceName) {
        List<ParkA> parks = new ArrayList<>();
        parks.addAll(publicParkRepo.getByProvinceNameProj(provinceName));
        parks.addAll(restrictParkRepo.getByProvinceNameProj(provinceName));
        return parks;
    }

    public List<String> getImages(int parkId) {
        return trailsImageRepositoryV1.getImagesByParkId(parkId);
    }


    public ParkA getParkById(int id) {
        return parkRepo.getById(id);
    }

    public List<ParkA> getParksByProvince(int provId) {
        return parkRepo.getByProvinceId(provId);
    }

    public List<ParkA> getParksByCountry(String coun) {
        return parkRepo.getByCountry(coun);
    }
}

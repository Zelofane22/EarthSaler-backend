package ecpi.earthsaler.service;

import ecpi.earthsaler.dao.LandDAO;
import ecpi.earthsaler.model.Land;

import java.util.List;

public class LandService {
    private LandDAO landDAO;

    public LandService() {
        this.landDAO = new LandDAO();
    }

    public List<Land> searchLands(String city, String district, double minPrice, double maxPrice, double minArea, double maxArea) {
        return landDAO.searchLands(city, district, minPrice, maxPrice, minArea, maxArea);
    }

    public List<Land> searchByPrice(double minPrice, double maxPrice) {
        return landDAO.searchByPrice(minPrice, maxPrice);
    }

    public List<Land> searchByArea(double minArea, double maxArea) {
        return (List<Land>) landDAO;
    }

    public List<Land> searchByLocation(String city, String district) {
        return landDAO.searchByLocation(city, district);
    }

    public List<Land> searchAdvanced(String city, String district, Double minPrice, Double maxPrice, Double minArea, Double maxArea) {
        return landDAO.searchAdvanced(city, district, minPrice, maxPrice, minArea, maxArea);
    }
}

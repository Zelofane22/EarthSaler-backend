package ecpi.earthsaler.dao;

import ecpi.earthsaler.model.Land;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LandDAO {
    private EntityManagerFactory emf;

    public LandDAO() {
        emf = Persistence.createEntityManagerFactory("real-estate-unit");
    }

    public List<Land> searchLands(String city, String district, double minPrice, double maxPrice, double minArea, double maxArea) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Land> query = em.createQuery("SELECT l FROM Land l WHERE l.city = :city AND l.district = :district AND l.price BETWEEN :minPrice AND :maxPrice AND l.area BETWEEN :minArea AND :maxArea", Land.class);
        query.setParameter("city", city);
        query.setParameter("district", district);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        query.setParameter("minArea", minArea);
        query.setParameter("maxArea", maxArea);

        List<Land> lands = query.getResultList();
        em.close();
        return lands;
    }

    public List<Land> searchByPrice(double minPrice, double maxPrice) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Land> query = em.createQuery("SELECT l FROM Land l WHERE l.price BETWEEN :minPrice AND :maxPrice", Land.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);

        List<Land> lands = query.getResultList();
        em.close();
        return lands;
    }

    public List<Land> searchByArea(double minArea, double maxArea) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Land> query = em.createQuery("SELECT l FROM Land l WHERE l.area BETWEEN :minArea AND :maxArea", Land.class);
        query.setParameter("minArea", minArea);
        query.setParameter("maxArea", maxArea);

        List<Land> lands = query.getResultList();
        em.close();
        return lands;
    }

    public List<Land> searchByLocation(String city, String district) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Land> query = em.createQuery("SELECT l FROM Land l WHERE l.city = :city AND l.district = :district", Land.class);
        query.setParameter("city", city);
        query.setParameter("district", district);

        List<Land> lands = query.getResultList();
        em.close();
        return lands;
    }

    public List<Land> searchAdvanced(String city, String district, Double minPrice, Double maxPrice, Double minArea, Double maxArea) {
        EntityManager em = emf.createEntityManager();
        StringBuilder sb = new StringBuilder("SELECT l FROM Land l WHERE 1=1");

        if (city != null && !city.isEmpty()) {
            sb.append(" AND l.city = :city");
        }
        if (district != null && !district.isEmpty()) {
            sb.append(" AND l.district = :district");
        }
        if (minPrice != null) {
            sb.append(" AND l.price >= :minPrice");
        }
        if (maxPrice != null) {
            sb.append(" AND l.price <= :maxPrice");
        }
        if (minArea != null) {
            sb.append(" AND l.area >= :minArea");
        }
        if (maxArea != null) {
            sb.append(" AND l.area <= :maxArea");
        }

        TypedQuery<Land> query = em.createQuery(sb.toString(), Land.class);

        if (city != null && !city.isEmpty()) {
            query.setParameter("city", city);
        }
        if (district != null && !district.isEmpty()) {
            query.setParameter("district", district);
        }
        if (minPrice != null) {
            query.setParameter("minPrice", minPrice);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        if (minArea != null) {
            query.setParameter("minArea", minArea);
        }
        if (maxArea != null) {
            query.setParameter("maxArea", maxArea);
        }

        List<Land> lands = query.getResultList();
        em.close();
        return lands;
    }
}

package com.dorandoran.dorandoranbackend.farmContentMap;

import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FarmContentMapRepository {

    private final EntityManager em;

    public void save(FarmContentMap farmContentMap) {
        em.persist(farmContentMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public FarmContentMap findById(Long id) {
        return em.find(FarmContentMap.class, id);
    }

    public List<FarmContentMap> findFarmContentMapsByFarmId(Long farmId) {
        return em.createQuery("SELECT fcm FROM FarmContentMap fcm WHERE fcm.farmId = :farmId", FarmContentMap.class)
                .setParameter("farmId", farmId)
                .getResultList();
    }

    public List<FarmContentMap> findFarmContentMapsByContentId(Long contentId) {
        return em.createQuery("SELECT fcm FROM FarmContentMap fcm WHERE fcm.contentId = :contentId", FarmContentMap.class)
                .setParameter("contentId", contentId)
                .getResultList();
    }

    public List<FarmContentMap> findAllFarmContentMaps() {
        return em.createQuery("SELECT fcm FROM FarmContentMap fcm", FarmContentMap.class)
                .getResultList();
    }
}

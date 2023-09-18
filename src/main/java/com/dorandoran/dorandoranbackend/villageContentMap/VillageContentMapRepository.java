package com.dorandoran.dorandoranbackend.villageContentMap;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VillageContentMapRepository {

    private final EntityManager em;

    public void save(VillageContentMap villageContentMap) {
        em.persist(villageContentMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public VillageContentMap findById(Long id) {
        return em.find(VillageContentMap.class, id);
    }

    public List<VillageContentMap> findVillageContentMapsByVillageId(Long villageId) {
        return em.createQuery("SELECT vcm FROM VillageContentMap vcm WHERE vcm.villageId = :villageId", VillageContentMap.class)
                .setParameter("villageId", villageId)
                .getResultList();
    }

    public List<VillageContentMap> findVillageContentMapsByContentId(Long contentId) {
        return em.createQuery("SELECT vcm FROM VillageContentMap vcm WHERE vcm.contentId = :contentId", VillageContentMap.class)
                .setParameter("contentId", contentId)
                .getResultList();
    }

    public List<VillageContentMap> findAllVillageContentMaps() {
        return em.createQuery("SELECT vcm FROM VillageContentMap vcm", VillageContentMap.class)
                .getResultList();
    }
}

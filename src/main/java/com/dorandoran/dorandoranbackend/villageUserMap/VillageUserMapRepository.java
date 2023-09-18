package com.dorandoran.dorandoranbackend.villageUserMap;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VillageUserMapRepository {

    private final EntityManager em;

    public void save(VillageUserMap villageUserMap) {
        em.persist(villageUserMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public VillageUserMap findById(Long id) {
        return em.find(VillageUserMap.class, id);
    }

    public List<VillageUserMap> findVillageUserMapsByVillageId(Long villageId) {
        return em.createQuery("SELECT vcm FROM VillageUserMap vcm WHERE vcm.villageId = :villageId", VillageUserMap.class)
                .setParameter("villageId", villageId)
                .getResultList();
    }

    public List<VillageUserMap> findVillageUserMapsByUserId(Long userId) {
        return em.createQuery("SELECT vcm FROM VillageUserMap vcm WHERE vcm.userId = :userId", VillageUserMap.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<VillageUserMap> findAllVillageUserMaps() {
        return em.createQuery("SELECT vcm FROM VillageUserMap vcm", VillageUserMap.class)
                .getResultList();
    }
}

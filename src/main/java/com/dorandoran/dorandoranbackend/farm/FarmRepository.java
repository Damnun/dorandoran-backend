package com.dorandoran.dorandoranbackend.farm;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FarmRepository {

    private final EntityManager em;

    public void save(Farm farm) {
        em.persist(farm);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Farm findById(Long id) {
        return em.find(Farm.class, id);
    }

    public List<Farm> findFarmsByMapId(Long mapId) {
        return em.createQuery("SELECT farm FROM Farm farm WHERE farm.mapId = :mapId", Farm.class)
                .setParameter("mapId", mapId)
                .getResultList();
    }

    public List<Farm> findFarmsByVillageId(Long villageId) {
        return em.createQuery("SELECT farm From Farm farm Where farm.villageId = :villageId", Farm.class)
                .setParameter("villageId", villageId)
                .getResultList();
    }

}

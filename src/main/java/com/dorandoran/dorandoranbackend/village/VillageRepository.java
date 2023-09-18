package com.dorandoran.dorandoranbackend.village;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VillageRepository {

    private final EntityManager em;

    public void save (Village village) {
        em.persist(village);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Village findById(Long id) {
        return em.find(Village.class, id);
    }

    public List<Village> findVillagesByVillageName(String name) {
        return em.createQuery("SELECT village From Village village WHERE village.villageName = :name", Village.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Village> findAllVillages() {
        return em.createQuery("SELECT village From Village village", Village.class)
                .getResultList();
    }

}

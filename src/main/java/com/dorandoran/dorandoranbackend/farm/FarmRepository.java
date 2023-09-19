package com.dorandoran.dorandoranbackend.farm;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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


    public List<Farm> findFarmsByUserId(Long userId) {
        return em.createQuery("SELECT farm From Farm farm Where farm.userId = :userId", Farm.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}

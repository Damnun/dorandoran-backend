package com.dorandoran.dorandoranbackend.map;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MapRepository {

    private final EntityManager em;

    public void save(Map map) {
        em.persist(map);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Map findById(Long id) {
        return em.find(Map.class, id);
    }


    public List<Map> findMapsByUserId(Long userId) {
        return em.createQuery("SELECT map FROM Map map WHERE map.userId = :userId", Map.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}

package com.dorandoran.dorandoranbackend.eventUserMap;

import com.dorandoran.dorandoranbackend.eventUserMap.EventUserMap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventUserMapRepository {

    private final EntityManager em;

    public void save(EventUserMap eventUserMap) {
        em.persist(eventUserMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public EventUserMap findById(Long id) {
        return em.find(EventUserMap.class, id);
    }

    public List<EventUserMap> findEventUserMapsByEventId(Long eventId) {
        return em.createQuery("SELECT eum FROM EventUserMap eum WHERE eum.eventId = :eventId", EventUserMap.class)
                .setParameter("eventId", eventId)
                .getResultList();
    }

    public List<EventUserMap> findEventUserMapsByUserId(Long userId) {
        return em.createQuery("SELECT eum FROM EventUserMap eum WHERE eum.userId = :userId", EventUserMap.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<EventUserMap> findAllEventUserMaps() {
        return em.createQuery("SELECT eum FROM EventUserMap eum", EventUserMap.class)
                .getResultList();
    }
}

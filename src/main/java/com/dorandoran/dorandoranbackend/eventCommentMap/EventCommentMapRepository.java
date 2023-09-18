package com.dorandoran.dorandoranbackend.eventCommentMap;

import com.dorandoran.dorandoranbackend.eventCommentMap.EventCommentMap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventCommentMapRepository {

    private final EntityManager em;

    public void save(EventCommentMap eventCommentMap) {
        em.persist(eventCommentMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public EventCommentMap findById(Long id) {
        return em.find(EventCommentMap.class, id);
    }

    public List<EventCommentMap> findEventCommentMapsByEventId(Long eventId) {
        return em.createQuery("SELECT eum FROM EventCommentMap eum WHERE eum.eventId = :eventId", EventCommentMap.class)
                .setParameter("eventId", eventId)
                .getResultList();
    }

    public List<EventCommentMap> findEventCommentMapsByCommentId(Long commentId) {
        return em.createQuery("SELECT eum FROM EventCommentMap eum WHERE eum.commentId = :commentId", EventCommentMap.class)
                .setParameter("commentId", commentId)
                .getResultList();
    }

    public List<EventCommentMap> findAllEventCommentMaps() {
        return em.createQuery("SELECT eum FROM EventCommentMap eum", EventCommentMap.class)
                .getResultList();
    }
}

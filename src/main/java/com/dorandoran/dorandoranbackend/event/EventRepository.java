package com.dorandoran.dorandoranbackend.event;

import com.dorandoran.dorandoranbackend.event.Event;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventRepository {

    private final EntityManager em;

    public void save (Event event) {
        em.persist(event);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Event findById(Long id) {
        return em.find(Event.class, id);
    }

    public List<Event> findEventsByEventTitle(String title) {
        return em.createQuery("SELECT event From Event event WHERE event.title = :title", Event.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Event> findEventsByEventCategory(String category) {
        return em.createQuery("SELECT event From Event event WHERE event.category = :category", Event.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<Event> findEventsByEventStatus(Integer status) {
        return em.createQuery("SELECT event From Event event WHERE event.status = :status", Event.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Event> findAllEvents() {
        return em.createQuery("SELECT event From Event event", Event.class)
                .getResultList();
    }

    public List<Event> findEventsByUserId(Long userId) {
        return em.createQuery("SELECT event FROM Event event WHERE event.userId = : userId", Event.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}

package com.dorandoran.dorandoranbackend.event;

import com.dorandoran.dorandoranbackend.event.Event;
import com.dorandoran.dorandoranbackend.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Long saveEvent(Event event) {
        eventRepository.save(event);
        return event.getId();
    }

    public void removeEvent(Long id) {
        eventRepository.remove(id);
    }

    public Event findEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> findEventsByEventTitle(String title) {
        return eventRepository.findEventsByEventTitle(title);
    }

    public List<Event> findEventsByEventCategory(String category) {
        return eventRepository.findEventsByEventCategory(category);
    }

    public List<Event> findEventsByEventStatus(Integer status) {
        return eventRepository.findEventsByEventStatus(status);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAllEvents();
    }

    public List<Event> findEventsByUserId(Long userId) {
        return eventRepository.findEventsByUserId(userId);
    }
}

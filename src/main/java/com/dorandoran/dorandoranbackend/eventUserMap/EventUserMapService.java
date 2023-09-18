package com.dorandoran.dorandoranbackend.eventUserMap;

import com.dorandoran.dorandoranbackend.eventUserMap.EventUserMap;
import com.dorandoran.dorandoranbackend.eventUserMap.EventUserMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventUserMapService {
    private final EventUserMapRepository eventUserMapRepository;

    public Long saveEventUserMap(EventUserMap eventUserMap) {
        eventUserMapRepository.save(eventUserMap);
        return eventUserMap.getId();
    }

    public void removeEventUserMap(Long id) {
        eventUserMapRepository.remove(id);
    }

    public EventUserMap findEventUserMapById(Long id) {
        return eventUserMapRepository.findById(id);
    }

    public List<EventUserMap> findEventUserMapsByEventId(Long eventId) {
        return eventUserMapRepository.findEventUserMapsByEventId(eventId);
    }

    public List<EventUserMap> findEventUserMapsByUserId(Long userId) {
        return eventUserMapRepository.findEventUserMapsByUserId(userId);
    }

    public List<EventUserMap> findAllEventUserMaps() {
        return eventUserMapRepository.findAllEventUserMaps();
    }
}
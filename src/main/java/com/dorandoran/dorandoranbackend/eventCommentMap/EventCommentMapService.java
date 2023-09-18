package com.dorandoran.dorandoranbackend.eventCommentMap;

import com.dorandoran.dorandoranbackend.eventCommentMap.EventCommentMap;
import com.dorandoran.dorandoranbackend.eventCommentMap.EventCommentMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventCommentMapService {
    private final EventCommentMapRepository eventCommentMapRepository;

    public Long saveEventCommentMap(EventCommentMap eventCommentMap) {
        eventCommentMapRepository.save(eventCommentMap);
        return eventCommentMap.getId();
    }

    public void removeEventCommentMap(Long id) {
        eventCommentMapRepository.remove(id);
    }

    public EventCommentMap findEventCommentMapById(Long id) {
        return eventCommentMapRepository.findById(id);
    }

    public List<EventCommentMap> findEventCommentMapsByEventId(Long eventId) {
        return eventCommentMapRepository.findEventCommentMapsByEventId(eventId);
    }

    public List<EventCommentMap> findEventCommentMapsByCommentId(Long commentId) {
        return eventCommentMapRepository.findEventCommentMapsByCommentId(commentId);
    }

    public List<EventCommentMap> findAllEventCommentMaps() {
        return eventCommentMapRepository.findAllEventCommentMaps();
    }
}
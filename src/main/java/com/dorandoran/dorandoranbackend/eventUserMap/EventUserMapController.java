package com.dorandoran.dorandoranbackend.eventUserMap;

import com.dorandoran.dorandoranbackend.eventUserMap.EventUserMap;
import com.dorandoran.dorandoranbackend.eventUserMap.EventUserMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventUserMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventUserMapController {

    private final EventUserMapService eventUserMapService;

    @PostMapping("/create")
    public String create(@RequestParam Long eventId, Long userId) {
        EventUserMap eventUserMap = new EventUserMap();
        eventUserMap.setEventId(eventId);
        eventUserMap.setUserId(userId);

        Long eventUserMapId = eventUserMapService.saveEventUserMap(eventUserMap);
        return eventUserMapId + "번 유저-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        eventUserMapService.removeEventUserMap(id);
        return id + "번 유저-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findEventUserMapById")
    public EventUserMap findEventUserMapById(Long id) {
        return eventUserMapService.findEventUserMapById(id);
    }

    @GetMapping("/findEventUserMapsByEventId")
    public List<EventUserMap> findEventUserMapsByEventId(Long eventId) {
        return eventUserMapService.findEventUserMapsByEventId(eventId);
    }

    @GetMapping("/findEventUserMapsByUserId")
    public List<EventUserMap> findEventUserMapsByUserId(Long userId) {
        return eventUserMapService.findEventUserMapsByUserId(userId);
    }

    @GetMapping("/findAllEventUserMaps")
    public List<EventUserMap> findAllEventUserMaps() {
        return eventUserMapService.findAllEventUserMaps();
    }
}

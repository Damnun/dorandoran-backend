package com.dorandoran.dorandoranbackend.eventCommentMap;

import com.dorandoran.dorandoranbackend.comment.CommentService;
import com.dorandoran.dorandoranbackend.eventCommentMap.EventCommentMap;
import com.dorandoran.dorandoranbackend.eventCommentMap.EventCommentMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventCommentMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventCommentMapController {

    private final EventCommentMapService eventCommentMapService;
    private final CommentService commentService;

    @PostMapping("/create")
    public String create(@RequestParam Long eventId, Long commentId) {
        EventCommentMap eventCommentMap = new EventCommentMap();
        eventCommentMap.setEventId(eventId);
        eventCommentMap.setCommentId(commentId);

        Long eventCommentMapId = eventCommentMapService.saveEventCommentMap(eventCommentMap);
        return eventCommentMapId + "번 유저-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        eventCommentMapService.removeEventCommentMap(id);
        return id + "번 유저-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findEventCommentMapById")
    public EventCommentMap findEventCommentMapById(Long id) {
        return eventCommentMapService.findEventCommentMapById(id);
    }

    @GetMapping("/findEventCommentMapsByEventId")
    public List<EventCommentMap> findEventCommentMapsByEventId(Long eventId) {
        return eventCommentMapService.findEventCommentMapsByEventId(eventId);
    }

    @GetMapping("/findEventCommentMapsByCommentId")
    public List<EventCommentMap> findEventCommentMapsByCommentId(Long commentId) {
        return eventCommentMapService.findEventCommentMapsByCommentId(commentId);
    }

    @GetMapping("/findAllEventCommentMaps")
    public List<EventCommentMap> findAllEventCommentMaps() {
        return eventCommentMapService.findAllEventCommentMaps();
    }

    @GetMapping("/findCommentsByEventId")
    public List<EventCommentMapDTO> findCommentsByEventId(Long eventId) {
        List<EventCommentMapDTO> result = new ArrayList<>();
        List<EventCommentMap> eventCommentMapList = eventCommentMapService.findEventCommentMapsByEventId(eventId);

        eventCommentMapList.forEach(eventCommentMap -> {
            EventCommentMapDTO currentEventCommentMapDTO = new EventCommentMapDTO();
            currentEventCommentMapDTO.setEventId(eventId);
            currentEventCommentMapDTO.setComment(commentService.findCommentById(eventCommentMap.getCommentId()));
            result.add(currentEventCommentMapDTO);
        });
        return result;
    }
}

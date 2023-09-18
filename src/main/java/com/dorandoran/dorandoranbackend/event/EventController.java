package com.dorandoran.dorandoranbackend.event;

import com.dorandoran.dorandoranbackend.event.Event;
import com.dorandoran.dorandoranbackend.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    private final EventService eventService;

    @PostMapping("/create")
    public String create(@RequestParam String title, String description, String category, Integer status, Long villageId) {
        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        event.setCategory(category);
        event.setStatus(status);
        event.setVillageId(villageId);

        Long id = eventService.saveEvent(event);

        return id + "번 이벤트 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        eventService.removeEvent(id);
        return id + "번 이벤트 삭제 완료";
    }

    @GetMapping("/findEventByEventId")
    public Event findEventByEventId(@RequestParam Long id) {
        return eventService.findEventById(id);
    }

    @GetMapping("/findEventsByTitle")
    public List<Event> findEventsByTitle(@RequestParam String title) {
        return eventService.findEventsByEventTitle(title);
    }

    @GetMapping("/findEventsByCategory")
    public List<Event> findEventsByCategory(@RequestParam String category) {
        return eventService.findEventsByEventCategory(category);
    }

    @GetMapping("/findEventsByStatus")
    public List<Event> findEventsByVillageId(@RequestParam Integer status) {
        return eventService.findEventsByEventStatus(status);
    }
}

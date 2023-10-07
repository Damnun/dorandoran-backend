package com.dorandoran.dorandoranbackend.map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MapController {

    private final MapService mapService;

    @PostMapping("/create")
    public String create(@RequestParam String name, String latitude, String longitude, Long userId) {
        Map map = new Map();
        map.setName(name);
        map.setLatitude(latitude);
        map.setLongitude(longitude);
        map.setUserId(userId);

        Long id = mapService.saveMap(map);

        return id + "번 맵 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        mapService.removeMap(id);
        return id + "번 맵 삭제 완료";
    }

    @GetMapping("/findMapByMapId")
    public Map findMapByMapId(@RequestParam Long id) {
        return mapService.findMapByMapId(id);
    }

    @GetMapping("/findMapsByUserId")
    public List<Map> findMapsByUserId(@RequestParam Long userId) {
        return mapService.findMapsByUserId(userId);
    }


}

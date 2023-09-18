package com.dorandoran.dorandoranbackend.villageContentMap;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villageContentMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VillageContentMapController {

    private final VillageContentMapService villageContentMapService;

    @PostMapping("/create")
    public String create(@RequestParam Long villageId, Long contentId) {
        VillageContentMap villageContentMap = new VillageContentMap();
        villageContentMap.setVillageId(villageId);
        villageContentMap.setContentId(contentId);

        Long villageContentMapId = villageContentMapService.saveVillageContentMap(villageContentMap);
        return villageContentMapId + "번 마을-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        villageContentMapService.removeVillageContentMap(id);
        return id + "번 마을-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findVillageContentMapById")
    public VillageContentMap findVillageContentMapById(Long id) {
        return villageContentMapService.findVillageContentMapById(id);
    }

    @GetMapping("/findVillageContentMapsByVillageId")
    public List<VillageContentMap> findVillageContentMapsByVillageId(Long villageId) {
        return villageContentMapService.findVillageContentMapsByVillageId(villageId);
    }

    @GetMapping("/findVillageContentMapsByContentId")
    public List<VillageContentMap> findVillageContentMapsByContentId(Long contentId) {
        return villageContentMapService.findVillageContentMapsByContentId(contentId);
    }

    @GetMapping("/findAllVillageContentMaps")
    public List<VillageContentMap> findAllVillageContentMaps() {
        return villageContentMapService.findAllVillageContentMaps();
    }
}

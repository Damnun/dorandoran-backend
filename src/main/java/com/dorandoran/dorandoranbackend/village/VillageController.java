package com.dorandoran.dorandoranbackend.village;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/village")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VillageController {

    private final VillageService villageService;

    @PostMapping("/create")
    public String create(@RequestParam String name, String description, String longitude, String latitude) {
        Village village = new Village();
        village.setVillageName(name);
        village.setVillageDescription(description);
        village.setLatitude(latitude);
        village.setLongitude(longitude);

        Long villageId = villageService.saveVillage(village);
        return villageId + "번 마을 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        villageService.removeVillage(id);
        return id + "번 마을 삭제 완료";
    }

    @GetMapping("/findVillageByVillageId")
    public Village findVillageByVillageId(Long id) {
        return villageService.findVillageById(id);
    }

    @GetMapping("/findVillagesByVillageName")
    public List<Village> findVillagesByVillageName(String name) {
        return villageService.findVillagesByVillageName(name);
    }

    @GetMapping("/findAllVillages")
    public List<Village> findAllVillages() {
        return villageService.findAllVillages();
    }
}
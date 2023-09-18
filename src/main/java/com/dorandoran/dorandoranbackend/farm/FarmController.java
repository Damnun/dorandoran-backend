package com.dorandoran.dorandoranbackend.farm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FarmController {

    private final FarmService farmService;

    @PostMapping("/create")
    public String create(@RequestParam String name, String description, String species, String want, String why, Long mapId, Long villageId) {
        Farm farm = new Farm();
        farm.setName(name);
        farm.setDescription(description);
        farm.setSpecies(species);
        farm.setWant(want);
        farm.setWhy(why);
        farm.setMapId(mapId);
        farm.setVillageId(villageId);

        Long farmId = farmService.saveFarm(farm);
        return farmId + "번 농장 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        farmService.removeFarm(id);
        return id + "번 농장 삭제 완료";
    }

    @GetMapping("/findFarmById")
    public Farm findFarmById(Long id) {
        return farmService.findFarmByFarmId(id);
    }

    @GetMapping("/findFarmsByMapId")
    public List<Farm> findFarmsByMapId(Long mapId) {
        return farmService.findFarmsByMapId(mapId);
    }

    @GetMapping("/findFarmsByVillageId")
    public List<Farm> findFarmsByVillageId(Long villageId) {
        return farmService.findFarmsByVillageId(villageId);
    }
}

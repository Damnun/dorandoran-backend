package com.dorandoran.dorandoranbackend.villageUserMap;

import com.dorandoran.dorandoranbackend.villageUserMap.VillageUserMap;
import com.dorandoran.dorandoranbackend.villageUserMap.VillageUserMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villageUserMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VillageUserMapController {

    private final VillageUserMapService villageUserMapService;

    @PostMapping("/create")
    public String create(@RequestParam Long villageId, Long userId) {
        VillageUserMap villageUserMap = new VillageUserMap();
        villageUserMap.setVillageId(villageId);
        villageUserMap.setUserId(userId);

        Long villageUserMapId = villageUserMapService.saveVillageUserMap(villageUserMap);
        return villageUserMapId + "번 유저-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        villageUserMapService.removeVillageUserMap(id);
        return id + "번 유저-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findVillageUserMapById")
    public VillageUserMap findVillageUserMapById(Long id) {
        return villageUserMapService.findVillageUserMapById(id);
    }

    @GetMapping("/findVillageUserMapsByVillageId")
    public List<VillageUserMap> findVillageUserMapsByVillageId(Long villageId) {
        return villageUserMapService.findVillageUserMapsByVillageId(villageId);
    }

    @GetMapping("/findVillageUserMapsByUserId")
    public List<VillageUserMap> findVillageUserMapsByUserId(Long userId) {
        return villageUserMapService.findVillageUserMapsByUserId(userId);
    }

    @GetMapping("/findAllVillageUserMaps")
    public List<VillageUserMap> findAllVillageUserMaps() {
        return villageUserMapService.findAllVillageUserMaps();
    }
}

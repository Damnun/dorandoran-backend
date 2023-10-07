package com.dorandoran.dorandoranbackend.farmContentMap;

import com.dorandoran.dorandoranbackend.content.ContentService;
import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMap;
import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/farmContentMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FarmContentMapController {

    private final FarmContentMapService farmContentMapService;
    private final ContentService contentService;

    @PostMapping("/create")
    public String create(@RequestParam Long farmId, Long contentId) {
        FarmContentMap farmContentMap = new FarmContentMap();
        farmContentMap.setFarmId(farmId);
        farmContentMap.setContentId(contentId);

        Long farmContentMapId = farmContentMapService.saveFarmContentMap(farmContentMap);
        return farmContentMapId + "번 농장-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        farmContentMapService.removeFarmContentMap(id);
        return id + "번 농장-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findFarmContentMapById")
    public FarmContentMap findFarmContentMapById(Long id) {
        return farmContentMapService.findFarmContentMapById(id);
    }

    @GetMapping("/findFarmContentMapsByFarmId")
    public List<FarmContentMap> findFarmContentMapsByFarmId(Long farmId) {
        return farmContentMapService.findFarmContentMapsByFarmId(farmId);
    }

    @GetMapping("/findFarmContentMapsByContentId")
    public List<FarmContentMap> findFarmContentMapsByContentId(Long contentId) {
        return farmContentMapService.findFarmContentMapsByContentId(contentId);
    }

    @GetMapping("/findAllFarmContentMaps")
    public List<FarmContentMap> findAllFarmContentMaps() {
        return farmContentMapService.findAllFarmContentMaps();
    }

    @GetMapping("/findFarmContentUrlsByFarmId")
    public List<FarmContentMapDTO> findFarmContentUrlsByFarmId(@RequestParam Long farmId) {
        List<FarmContentMapDTO> result = new ArrayList<>();
        List<FarmContentMap> farmContentMapList = farmContentMapService.findFarmContentMapsByFarmId(farmId);

        farmContentMapList.forEach(farmContentMap -> {
            FarmContentMapDTO currentFarmContentMapDTO = new FarmContentMapDTO();
            currentFarmContentMapDTO.setFarmId(farmId);
            currentFarmContentMapDTO.setContentUrl(contentService.findContentById(farmContentMap.getContentId()).getContentUrl());
            result.add(currentFarmContentMapDTO);
        });
        return result;
    }
}

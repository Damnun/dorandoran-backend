package com.dorandoran.dorandoranbackend.dorandoranContentMap;

import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMap;
import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dorandoranContentMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoranDoranContentMapController {

    private final DoranDoranContentMapService dorandoranContentMapService;

    @PostMapping("/create")
    public String create(@RequestParam Long dorandoranId, Long contentId) {
        DoranDoranContentMap dorandoranContentMap = new DoranDoranContentMap();
        dorandoranContentMap.setDorandoranId(dorandoranId);
        dorandoranContentMap.setContentId(contentId);

        Long dorandoranContentMapId = dorandoranContentMapService.saveDoranDoranContentMap(dorandoranContentMap);
        return dorandoranContentMapId + "번 농장-컨텐츠 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        dorandoranContentMapService.removeDoranDoranContentMap(id);
        return id + "번 농장-컨텐츠 맵 삭제 완료";
    }

    @GetMapping("/findDoranDoranContentMapById")
    public DoranDoranContentMap findDoranDoranContentMapById(Long id) {
        return dorandoranContentMapService.findDoranDoranContentMapById(id);
    }

    @GetMapping("/findDoranDoranContentMapsByDoranDoranId")
    public List<DoranDoranContentMap> findDoranDoranContentMapsByDoranDoranId(Long dorandoranId) {
        return dorandoranContentMapService.findDoranDoranContentMapsByDoranDoranId(dorandoranId);
    }

    @GetMapping("/findDoranDoranContentMapsByContentId")
    public List<DoranDoranContentMap> findDoranDoranContentMapsByContentId(Long contentId) {
        return dorandoranContentMapService.findDoranDoranContentMapsByContentId(contentId);
    }

    @GetMapping("/findAllDoranDoranContentMaps")
    public List<DoranDoranContentMap> findAllDoranDoranContentMaps() {
        return dorandoranContentMapService.findAllDoranDoranContentMaps();
    }
}
package com.dorandoran.dorandoranbackend.content;


import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMap;
import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMapService;
import com.dorandoran.dorandoranbackend.farm.Farm;
import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMap;
import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMapService;
import com.dorandoran.dorandoranbackend.villageContentMap.VillageContentMap;
import com.dorandoran.dorandoranbackend.villageContentMap.VillageContentMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContentController {

    private final ContentService contentService;
    private final VillageContentMapService villageContentMapService;
    private final DoranDoranContentMapService doranDoranContentMapService;
    private final FarmContentMapService farmContentMapService;

    @PostMapping("/create")
    public List<Long> create(@RequestParam List<MultipartFile> multipartFiles, Long userId, Long targetId, Integer category) {
        List<Long> uploadedFileIdList = new ArrayList<>();

        List<List<String>> dataListResult = contentService.uploadFile(multipartFiles);
        for (int i = 0; i < dataListResult.size(); i++) {
            Content content = new Content();
            content.setContentVolume(dataListResult.get(i).get(1));
            content.setContentUrl(dataListResult.get(i).get(2));
            content.setUserId(userId);

            Long contentId = contentService.saveContent(content);
            uploadedFileIdList.add(contentId);

            if (category == 1){ // village
                VillageContentMap villageContentMap = new VillageContentMap();
                villageContentMap.setContentId(contentId);
                villageContentMap.setVillageId(targetId);

                villageContentMapService.saveVillageContentMap(villageContentMap);
            }

            else if (category == 2) { // dorandoran
                DoranDoranContentMap doranDoranContentMap = new DoranDoranContentMap();
                doranDoranContentMap.setContentId(contentId);
                doranDoranContentMap.setDorandoranId(targetId);

                doranDoranContentMapService.saveDoranDoranContentMap(doranDoranContentMap);
            }

            else if (category == 3) { // farm
                FarmContentMap farmContentMap = new FarmContentMap();
                farmContentMap.setContentId(contentId);
                farmContentMap.setFarmId(targetId);

                farmContentMapService.saveFarmContentMap(farmContentMap);
            }
        }

        return uploadedFileIdList;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        contentService.removeContent(id);
        return id + "번 컨텐츠 삭제 완료";
    }

    @GetMapping("/findContentByContentId")
    public Content findContentByContentId(@RequestParam Long contentId) {
        return contentService.findContentById(contentId);
    }

    @GetMapping("/findAllContents")
    public List<Content> findAllContents() {
        return contentService.findAllContents();
    }

}

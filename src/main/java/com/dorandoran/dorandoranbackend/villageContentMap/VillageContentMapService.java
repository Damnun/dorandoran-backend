package com.dorandoran.dorandoranbackend.villageContentMap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VillageContentMapService {
    private final VillageContentMapRepository villageContentMapRepository;

    public Long saveVillageContentMap(VillageContentMap villageContentMap) {
        villageContentMapRepository.save(villageContentMap);
        return villageContentMap.getId();
    }

    public void removeVillageContentMap(Long id) {
        villageContentMapRepository.remove(id);
    }

    public VillageContentMap findVillageContentMapById(Long id) {
        return villageContentMapRepository.findById(id);
    }

    public List<VillageContentMap> findVillageContentMapsByVillageId(Long villageId) {
        return villageContentMapRepository.findVillageContentMapsByVillageId(villageId);
    }

    public List<VillageContentMap> findVillageContentMapsByContentId(Long contentId) {
        return villageContentMapRepository.findVillageContentMapsByContentId(contentId);
    }

    public List<VillageContentMap> findAllVillageContentMaps() {
        return villageContentMapRepository.findAllVillageContentMaps();
    }
}

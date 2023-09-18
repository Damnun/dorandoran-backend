package com.dorandoran.dorandoranbackend.farmContentMap;

import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMap;
import com.dorandoran.dorandoranbackend.farmContentMap.FarmContentMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmContentMapService {
    private final FarmContentMapRepository farmContentMapRepository;

    public Long saveFarmContentMap(FarmContentMap farmContentMap) {
        farmContentMapRepository.save(farmContentMap);
        return farmContentMap.getId();
    }

    public void removeFarmContentMap(Long id) {
        farmContentMapRepository.remove(id);
    }

    public FarmContentMap findFarmContentMapById(Long id) {
        return farmContentMapRepository.findById(id);
    }

    public List<FarmContentMap> findFarmContentMapsByFarmId(Long farmId) {
        return farmContentMapRepository.findFarmContentMapsByFarmId(farmId);
    }

    public List<FarmContentMap> findFarmContentMapsByContentId(Long contentId) {
        return farmContentMapRepository.findFarmContentMapsByContentId(contentId);
    }

    public List<FarmContentMap> findAllFarmContentMaps() {
        return farmContentMapRepository.findAllFarmContentMaps();
    }
}

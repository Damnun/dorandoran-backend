package com.dorandoran.dorandoranbackend.map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;

    public Long saveMap(Map map) {
        mapRepository.save(map);
        return map.getId();
    }

    public void removeMap(Long id) {
        mapRepository.remove(id);
    }

    public Map findMapByMapId(Long id) {
        return mapRepository.findById(id);
    }

    public List<Map> findMapsByUserId(Long userId) {
        return mapRepository.findMapsByUserId(userId);
    }

    public List<Map> findMapsByVillageId(Long villageId) {
        return mapRepository.findMapsByVillageId(villageId);
    }

}

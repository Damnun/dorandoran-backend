package com.dorandoran.dorandoranbackend.villageUserMap;

import com.dorandoran.dorandoranbackend.villageUserMap.VillageUserMap;
import com.dorandoran.dorandoranbackend.villageUserMap.VillageUserMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VillageUserMapService {
    private final VillageUserMapRepository villageUserMapRepository;

    public Long saveVillageUserMap(VillageUserMap villageUserMap) {
        villageUserMapRepository.save(villageUserMap);
        return villageUserMap.getId();
    }

    public void removeVillageUserMap(Long id) {
        villageUserMapRepository.remove(id);
    }

    public VillageUserMap findVillageUserMapById(Long id) {
        return villageUserMapRepository.findById(id);
    }

    public List<VillageUserMap> findVillageUserMapsByVillageId(Long villageId) {
        return villageUserMapRepository.findVillageUserMapsByVillageId(villageId);
    }

    public List<VillageUserMap> findVillageUserMapsByUserId(Long userId) {
        return villageUserMapRepository.findVillageUserMapsByUserId(userId);
    }

    public List<VillageUserMap> findAllVillageUserMaps() {
        return villageUserMapRepository.findAllVillageUserMaps();
    }
}
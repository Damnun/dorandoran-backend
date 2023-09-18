package com.dorandoran.dorandoranbackend.village;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VillageService {

    private final VillageRepository villageRepository;

    public Long saveVillage(Village village) {
        villageRepository.save(village);
        return village.getId();
    }

    public void removeVillage(Long id) {
        villageRepository.remove(id);
    }

    public Village findVillageById(Long id) {
        return villageRepository.findById(id);
    }

    public List<Village> findVillagesByVillageName(String name) {
        return villageRepository.findVillagesByVillageName(name);
    }

    public List<Village> findAllVillages() {
        return villageRepository.findAllVillages();
    }
}

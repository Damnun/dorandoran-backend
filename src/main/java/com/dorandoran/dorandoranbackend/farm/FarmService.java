package com.dorandoran.dorandoranbackend.farm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {

    private final FarmRepository farmRepository;

    public Long saveFarm(Farm farm) {
        farmRepository.save(farm);
        return farm.getId();
    }

    public void removeFarm(Long id) {
        farmRepository.remove(id);
    }

    public Farm findFarmByFarmId(Long id) {
        return farmRepository.findById(id);
    }

    public List<Farm> findFarmsByUserId(Long userId) {
        return farmRepository.findFarmsByUserId(userId);
    }
}

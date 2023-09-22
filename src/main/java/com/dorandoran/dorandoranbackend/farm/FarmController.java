package com.dorandoran.dorandoranbackend.farm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FarmController {

    private final FarmService farmService;

    @PostMapping("/create")
    public Long create(@RequestParam String name, String species, String want, String hobit, String why, String address, Long userId) {
        Farm farm = new Farm();
        farm.setName(name);
        farm.setSpecies(species);
        farm.setHobit(hobit);
        farm.setWant(want);
        farm.setWhy(why);
        farm.setAddress(address);
        farm.setUserId(userId);

        Long farmId = farmService.saveFarm(farm);
        return farmId;
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        farmService.removeFarm(id);
        return id + "번 농장 삭제 완료";
    }

    @GetMapping("/findFarmById")
    public Farm findFarmById(Long id) {
        return farmService.findFarmByFarmId(id);
    }

    @GetMapping("/findFarmsByUserId")
    public List<Farm> findFarmsByUserId(Long userId) {
        return farmService.findFarmsByUserId(userId);
    }

    @GetMapping("/findAllFarms")
    public List<Farm> findAllFarms() {
        return farmService.findAllFarms();
    }
}

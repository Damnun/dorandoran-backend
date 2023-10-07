package com.dorandoran.dorandoranbackend.benefit;

import com.dorandoran.dorandoranbackend.benefit.Benefit;
import com.dorandoran.dorandoranbackend.benefit.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/benefit")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BenefitController {

    private final BenefitService benefitService;

    @PostMapping("/create")
    public String create(@RequestParam String title, String category, String agency, String description, String qualification,
                         String standard, Timestamp started, Timestamp ended, String url) {
        Benefit benefit = new Benefit();
        benefit.setTitle(title);
        benefit.setCategory(category);
        benefit.setAgency(agency);
        benefit.setDescription(description);
        benefit.setQualification(qualification);
        benefit.setStandard(standard);
        benefit.setStarted(started);
        benefit.setEnded(ended);
        benefit.setUrl(url);

        Long id = benefitService.saveBenefit(benefit);

        return id + "번 혜택 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        benefitService.removeBenefit(id);
        return id + "번 혜택 삭제 완료";
    }

    @GetMapping("/findBenefitByBenefitId")
    public Benefit findBenefitByBenefitId(@RequestParam Long id) {
        return benefitService.findBenefitById(id);
    }

    @GetMapping("/findBenefitsByTitle")
    public List<Benefit> findBenefitsByTitle(@RequestParam String title) {
        return benefitService.findBenefitsByBenefitTitle(title);
    }

    @GetMapping("/findBenefitsByAgency")
    public List<Benefit> findBenefitsByCategory(@RequestParam String agency) {
        return benefitService.findBenefitsByBenefitAgency(agency);
    }

    @GetMapping("/findAllBenefits")
    public List<Benefit> findAllBenefits() {
        return benefitService.findAllBenefits();
    }
}

package com.dorandoran.dorandoranbackend.benefit;

import com.dorandoran.dorandoranbackend.benefit.Benefit;
import com.dorandoran.dorandoranbackend.benefit.BenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BenefitService {

    private final BenefitRepository benefitRepository;

    public Long saveBenefit(Benefit benefit) {
        benefitRepository.save(benefit);
        return benefit.getId();
    }

    public void removeBenefit(Long id) {
        benefitRepository.remove(id);
    }

    public Benefit findBenefitById(Long id) {
        return benefitRepository.findById(id);
    }

    public List<Benefit> findBenefitsByBenefitTitle(String title) {
        return benefitRepository.findBenefitsByTitle(title);
    }

    public List<Benefit> findBenefitsByBenefitAgency(String agency) {
        return benefitRepository.findBenefitsByAgency(agency);
    }

    public List<Benefit> findAllBenefits() {
        return benefitRepository.findAllBenefits();
    }
}

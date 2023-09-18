package com.dorandoran.dorandoranbackend.benefit;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BenefitRepository {

    private final EntityManager em;

    public void save(Benefit benefit) {
        em.persist(benefit);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Benefit findById(Long id) {
        return em.find(Benefit.class, id);
    }

    public List<Benefit> findBenefitsByTitle(String title) {
        return em.createQuery("SELECT benefit FROM Benefit benefit WHERE benefit.title = :title", Benefit.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Benefit> findBenefitsByAgency(String agency) {
        return em.createQuery("SELECT benefit FROM Benefit benefit WHERE benefit.agency = :agency", Benefit.class)
                .setParameter("agency", agency)
                .getResultList();
    }

    public List<Benefit> findAllBenefits() {
        return em.createQuery("SELECT benefit FROM Benefit benefit", Benefit.class)
                .getResultList();
    }
}

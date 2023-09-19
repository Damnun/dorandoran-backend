package com.dorandoran.dorandoranbackend.dorandoran;

import com.dorandoran.dorandoranbackend.dorandoran.DoranDoran;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoranDoranRepository {

    private final EntityManager em;

    public void save (DoranDoran dorandoran) {
        em.persist(dorandoran);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public DoranDoran findById(Long id) {
        return em.find(DoranDoran.class, id);
    }

    public List<DoranDoran> findDoranDoransByDoranDoranTitle(String title) {
        return em.createQuery("SELECT dorandoran From DoranDoran dorandoran WHERE dorandoran.title = :title", DoranDoran.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<DoranDoran> findDoranDoransByUserId(Long userId) {
        return em.createQuery("SELECT dorandoran FROM DoranDoran dorandoran WHERE dorandoran.userId = :userId", DoranDoran.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<DoranDoran> findAllDoranDorans() {
        return em.createQuery("SELECT dorandoran From DoranDoran dorandoran", DoranDoran.class)
                .getResultList();
    }

}

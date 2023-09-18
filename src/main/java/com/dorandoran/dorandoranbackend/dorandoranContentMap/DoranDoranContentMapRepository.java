package com.dorandoran.dorandoranbackend.dorandoranContentMap;

import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoranDoranContentMapRepository {

    private final EntityManager em;

    public void save(DoranDoranContentMap dorandoranContentMap) {
        em.persist(dorandoranContentMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public DoranDoranContentMap findById(Long id) {
        return em.find(DoranDoranContentMap.class, id);
    }

    public List<DoranDoranContentMap> findDoranDoranContentMapsByDoranDoranId(Long dorandoranId) {
        return em.createQuery("SELECT fcm FROM DoranDoranContentMap fcm WHERE fcm.dorandoranId = :dorandoranId", DoranDoranContentMap.class)
                .setParameter("dorandoranId", dorandoranId)
                .getResultList();
    }

    public List<DoranDoranContentMap> findDoranDoranContentMapsByContentId(Long contentId) {
        return em.createQuery("SELECT fcm FROM DoranDoranContentMap fcm WHERE fcm.contentId = :contentId", DoranDoranContentMap.class)
                .setParameter("contentId", contentId)
                .getResultList();
    }

    public List<DoranDoranContentMap> findAllDoranDoranContentMaps() {
        return em.createQuery("SELECT fcm FROM DoranDoranContentMap fcm", DoranDoranContentMap.class)
                .getResultList();
    }
}

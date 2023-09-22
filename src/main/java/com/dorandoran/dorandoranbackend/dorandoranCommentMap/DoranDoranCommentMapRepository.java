package com.dorandoran.dorandoranbackend.dorandoranCommentMap;

import com.dorandoran.dorandoranbackend.dorandoranCommentMap.DoranDoranCommentMap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoranDoranCommentMapRepository {

    private final EntityManager em;

    public void save(DoranDoranCommentMap dorandoranCommentMap) {
        em.persist(dorandoranCommentMap);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public DoranDoranCommentMap findById(Long id) {
        return em.find(DoranDoranCommentMap.class, id);
    }

    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByDoranDoranId(Long dorandoranId) {
        return em.createQuery("SELECT eum FROM DoranDoranCommentMap eum WHERE eum.dorandoranId = :dorandoranId", DoranDoranCommentMap.class)
                .setParameter("dorandoranId", dorandoranId)
                .getResultList();
    }

    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByCommentId(Long commentId) {
        return em.createQuery("SELECT eum FROM DoranDoranCommentMap eum WHERE eum.commentId = :commentId", DoranDoranCommentMap.class)
                .setParameter("commentId", commentId)
                .getResultList();
    }

    public List<DoranDoranCommentMap> findAllDoranDoranCommentMaps() {
        return em.createQuery("SELECT eum FROM DoranDoranCommentMap eum", DoranDoranCommentMap.class)
                .getResultList();
    }

}

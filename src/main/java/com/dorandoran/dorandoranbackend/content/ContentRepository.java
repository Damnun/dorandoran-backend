package com.dorandoran.dorandoranbackend.content;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ContentRepository {

    private final EntityManager em;

    public void save(Content content) {
        em.persist(content);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Content findById(Long id) {
        return em.find(Content.class, id);
    }

}

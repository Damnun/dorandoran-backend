package com.dorandoran.dorandoranbackend.content;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Content> findAllContents() {
        return em.createQuery("SELECT content FROM Content content", Content.class)
                .getResultList();
    }


}

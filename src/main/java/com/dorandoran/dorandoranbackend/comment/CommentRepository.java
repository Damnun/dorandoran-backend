package com.dorandoran.dorandoranbackend.comment;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public void remove(Long id) {
        em.remove(findById(id));
    }

    public Comment findById(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findCommentsByStatus(Integer status) {
        return em.createQuery("SELECT comment FROM Comment comment WHERE comment.status = :status", Comment.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Comment> findCommentsByUserId(Long userId) {
        return em.createQuery("SELECT comment FROM Comment comment WHERE comment.userId = :userId", Comment.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Comment> findAllComments() {
        return em.createQuery("SELECT comment FROM Comment comment", Comment.class)
                .getResultList();
    }
}

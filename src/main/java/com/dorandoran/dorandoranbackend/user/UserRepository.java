package com.dorandoran.dorandoranbackend.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public void remove(Integer id) {
        em.remove(findById(id));
    }

    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    public Optional<User> findByUserId(String userId) {
        List<User> user = em.createQuery("SELECT user FROM User user WHERE user.id = :userId", User.class)
                .setParameter("userId", userId)
                .getResultList();
        return user.stream().findAny();
    }

    public Optional<User> findByUserAccountId(String accountId) {
        List<User> user = em.createQuery("SELECT user FROM User user WHERE user.accountId = :accountId", User.class)
                .setParameter("accountId", accountId)
                .getResultList();
        return user.stream().findAny();
    }

    public List<User> findAllUsers() {
        return em.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    public void setUserPasswordByUserId(Integer userId, String password) {
        em.createQuery("UPDATE User user SET user.password = :password WHERE user.id = :userId")
                .setParameter("password", password)
                .setParameter("userId", userId)
                .executeUpdate();
        em.clear();
    }

}

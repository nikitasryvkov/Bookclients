package com.bookclients.bookingclients_service.repositories.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.User;
import com.bookclients.bookingclients_service.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl extends CRUDRepository<User> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional
                .ofNullable(entityManager.createQuery("SELECT u FROM User u WHERE u.Username = :username", User.class)
                        .setParameter("username", username).getSingleResult());
    }

    @Override
    public boolean existUserId(UUID id) {
        return (boolean) entityManager.createQuery("SELECT COUNT(u) > 0 FROM User u WHERE u.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<UUID> findAllId() {
        return entityManager.createQuery("SELECT u.id FROM User u", UUID.class).getResultList();
    }
}

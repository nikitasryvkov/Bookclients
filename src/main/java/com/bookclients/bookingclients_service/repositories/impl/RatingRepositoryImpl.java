package com.bookclients.bookingclients_service.repositories.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.Rating;
import com.bookclients.bookingclients_service.repositories.RatingRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RatingRepositoryImpl extends CRUDRepository<Rating> implements RatingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public RatingRepositoryImpl() {
        super(Rating.class);
    }

    @Override
    public Optional<List<Rating>> getAllRatingByUserId(UUID id) {
        return Optional
                .ofNullable(entityManager.createQuery("SELECT r FROM Rating r WHERE recipient.id = :id", Rating.class)
                        .setParameter("id", id).getResultList());
    }
}

package com.bookclients.bookingclients_service.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.Feedback;
import com.bookclients.bookingclients_service.repositories.FeedbackRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FeedbackRepositoryImpl extends CRUDRepository<Feedback> implements FeedbackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public FeedbackRepositoryImpl() {
        super(Feedback.class);
    }

    @Override
    public List<Feedback> findAllByServiceId(UUID id) {
        return entityManager.createQuery("SELECT f FROM Feedback f WHERE f.serviceId = :id", Feedback.class)
                .setParameter("id", id)
                .getResultList();
    }

}

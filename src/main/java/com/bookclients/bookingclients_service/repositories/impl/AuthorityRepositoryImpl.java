package com.bookclients.bookingclients_service.repositories.impl;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.Authority;
import com.bookclients.bookingclients_service.repositories.AuthorityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AuthorityRepositoryImpl extends CRUDRepository<Authority> implements AuthorityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AuthorityRepositoryImpl() {
        super(Authority.class);
    }
}

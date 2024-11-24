package com.bookclients.bookingclients_service.repositories.impl;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.ServiceCategory;
import com.bookclients.bookingclients_service.repositories.ServiceCategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ServiceCategoryRepositoryImpl extends CRUDRepository<ServiceCategory>
        implements ServiceCategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ServiceCategoryRepositoryImpl() {
        super(ServiceCategory.class);
    }
}

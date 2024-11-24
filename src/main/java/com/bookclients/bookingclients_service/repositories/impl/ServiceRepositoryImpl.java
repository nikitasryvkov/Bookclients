package com.bookclients.bookingclients_service.repositories.impl;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.Service;
import com.bookclients.bookingclients_service.repositories.ServiceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ServiceRepositoryImpl extends CRUDRepository<Service> implements ServiceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public ServiceRepositoryImpl() {
		super(Service.class);
	}
}

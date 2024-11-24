package com.bookclients.bookingclients_service.repositories.impl;

import org.springframework.stereotype.Repository;

import com.bookclients.bookingclients_service.models.Appointment;
import com.bookclients.bookingclients_service.repositories.AppointmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AppointmentRepositoryImpl extends CRUDRepository<Appointment> implements AppointmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AppointmentRepositoryImpl() {
        super(Appointment.class);
    }
}

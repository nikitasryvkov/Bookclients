package com.bookclients.bookingclients_service.repositories;

import java.util.Optional;
import java.util.UUID;

import com.bookclients.bookingclients_service.models.Service;

public interface ServiceRepository {
    Optional<Service> findById(UUID id);

    Service save(Service service);

    Service update(Service service);
}

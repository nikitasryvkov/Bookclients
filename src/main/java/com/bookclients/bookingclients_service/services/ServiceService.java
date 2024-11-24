package com.bookclients.bookingclients_service.services;

import java.util.UUID;

import com.bookclients.bookingclients_service.dtos.request.service.ServiceCreateDTO;
import com.bookclients.bookingclients_service.dtos.request.service.ServiceUpdateDTO;

public interface ServiceService {
    ServiceUpdateDTO updateService(UUID id, ServiceUpdateDTO user);

    ServiceCreateDTO createService(ServiceCreateDTO user);
}

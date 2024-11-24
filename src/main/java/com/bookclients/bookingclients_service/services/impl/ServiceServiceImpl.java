package com.bookclients.bookingclients_service.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookclients.bookingclients_service.dtos.request.service.ServiceCreateDTO;
import com.bookclients.bookingclients_service.dtos.request.service.ServiceUpdateDTO;
import com.bookclients.bookingclients_service.models.Service;
import com.bookclients.bookingclients_service.repositories.ServiceRepository;
import com.bookclients.bookingclients_service.services.ServiceService;

public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository, ModelMapper modelMapper) {
        this.serviceRepository = serviceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ServiceUpdateDTO updateService(UUID id, ServiceUpdateDTO serviceDTO) {
        Service service = serviceRepository.findById(id).orElseThrow(
                () -> new com.bookclients.bookingclients_service.exceptions.service.ServiceNotFoundException(
                        "Услуга с id: " + id + " не найдена"));

        service.setTitle(serviceDTO.getTitle());
        service.setDescription(serviceDTO.getDescription());
        service.setCategory(serviceDTO.getCategory());
        service.setPrice(serviceDTO.getPrice());
        service.setStatus(serviceDTO.getStatus());
        serviceRepository.update(service);

        return modelMapper.map(service, ServiceUpdateDTO.class);
    }

    @Override
    public ServiceCreateDTO createService(ServiceCreateDTO service) {
        serviceRepository.save(modelMapper.map(service, Service.class));
        return service;
    }

}

package com.bookclients.bookingclients_service.dtos.request.service;

import com.bookclients.bookingclients_service.enums.ServiceStatusEnum;
import com.bookclients.bookingclients_service.models.ServiceCategory;

public class ServiceUpdateDTO {
    private String title;
    private String description;
    private ServiceCategory category;
    private Long price;
    private ServiceStatusEnum status;

    public ServiceUpdateDTO(String title, String description, ServiceCategory category, Long price,
            ServiceStatusEnum status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.status = ServiceStatusEnum.PUBLISHED;
    }

    protected ServiceUpdateDTO() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ServiceCategory getCategory() {
        return category;
    }

    public Long getPrice() {
        return price;
    }

    public ServiceStatusEnum getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(ServiceCategory category) {
        this.category = category;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setStatus(ServiceStatusEnum status) {
        this.status = status;
    }
}

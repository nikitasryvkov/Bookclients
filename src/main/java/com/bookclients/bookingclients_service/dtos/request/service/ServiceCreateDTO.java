package com.bookclients.bookingclients_service.dtos.request.service;

import com.bookclients.bookingclients_service.enums.ServiceStatusEnum;
import com.bookclients.bookingclients_service.models.ServiceCategory;
import com.bookclients.bookingclients_service.models.User;

public class ServiceCreateDTO {
    private String title;
    private String description;
    private ServiceCategory category;
    private Long price;
    private User createdBy;
    private ServiceStatusEnum status;

    public ServiceCreateDTO(String title, String description, ServiceCategory category, Long price, User createdBy,
            ServiceStatusEnum status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.createdBy = createdBy;
        this.status = ServiceStatusEnum.PUBLISHED;
    }

    protected ServiceCreateDTO() {
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

    public User getCreatedBy() {
        return createdBy;
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

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setStatus(ServiceStatusEnum status) {
        this.status = status;
    }
}

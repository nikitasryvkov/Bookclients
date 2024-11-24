package com.bookclients.bookingclients_service.models;

import com.bookclients.bookingclients_service.enums.ServiceStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service extends BaseEntity {
    private String title;
    private String description;
    private ServiceCategory category;
    private Long price;
    private User createdBy;
    private ServiceStatusEnum status;

    public Service(String title, String description, ServiceCategory category, Long price, User createdBy) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.createdBy = createdBy;
        this.status = ServiceStatusEnum.PUBLISHED;
    }

    protected Service() {
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @ManyToOne
    @JoinColumn(name = "service_category_id")
    public ServiceCategory getCategory() {
        return category;
    }

    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getCreatedBy() {
        return createdBy;
    }

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
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

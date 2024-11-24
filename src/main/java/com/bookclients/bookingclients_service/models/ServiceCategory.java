package com.bookclients.bookingclients_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_category")
public class ServiceCategory extends BaseEntity {
    private String name;

    public ServiceCategory(String name) {
        this.name = name;
    }

    protected ServiceCategory() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

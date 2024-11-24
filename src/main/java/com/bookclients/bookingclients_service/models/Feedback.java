package com.bookclients.bookingclients_service.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity {
    private LocalDateTime creationDate;
    private String text;
    private Service service;
    private User createdBy;
    private Rating estimation;

    public Feedback(LocalDateTime creationDate, String text, Service service, User createdBy, Rating estimation) {
        this.creationDate = creationDate;
        this.text = text;
        this.service = service;
        this.createdBy = createdBy;
        this.estimation = estimation;
    }

    protected Feedback() {
    }

    @Column(name = "creation_date")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    @ManyToOne
    @JoinColumn(name = "service_id")
    public Service getService() {
        return service;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getCreatedBy() {
        return createdBy;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public Rating getEstimation() {
        return estimation;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setEstimation(Rating estimation) {
        this.estimation = estimation;
    }
}

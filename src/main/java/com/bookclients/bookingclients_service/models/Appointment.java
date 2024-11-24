package com.bookclients.bookingclients_service.models;

import java.time.LocalDateTime;

import com.bookclients.bookingclients_service.enums.AppointmentStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Реализовать проверку количество активных записей у пользователя(не более 2-х)
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {
    private LocalDateTime creationDate;
    private LocalDateTime recordingDate;
    private User client;
    private User master;
    private Service service;
    private AppointmentStatusEnum status;

    public Appointment(LocalDateTime creationDate, LocalDateTime recordingDate, User client, User master,
            Service service, AppointmentStatusEnum status) {
        this.creationDate = creationDate;
        this.recordingDate = recordingDate;
        this.client = client;
        this.master = master;
        this.service = service;
        this.status = status;
    }

    protected Appointment() {
    }

    @Column(name = "creation_date")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Column(name = "recording_date")
    public LocalDateTime getRecordingDate() {
        return recordingDate;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public User getClient() {
        return client;
    }

    @ManyToOne
    @JoinColumn(name = "master_id")
    public User getMaster() {
        return master;
    }

    @ManyToOne
    @JoinColumn(name = "service_id")
    public Service getService() {
        return service;
    }

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public AppointmentStatusEnum getStatus() {
        return status;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setRecordingDate(LocalDateTime recordingDate) {
        this.recordingDate = recordingDate;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setStatus(AppointmentStatusEnum status) {
        this.status = status;
    }
}

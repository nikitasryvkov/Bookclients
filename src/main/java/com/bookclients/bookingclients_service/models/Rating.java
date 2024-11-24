package com.bookclients.bookingclients_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating extends BaseEntity {
    private Integer estimation;
    private User sender;
    private User recipient;

    public Rating(Integer estimation, User sender, User recipient) {
        this.estimation = estimation;
        this.sender = sender;
        this.recipient = recipient;
    }

    protected Rating() {
    }

    @Column(name = "estimation")
    public Integer getEstimation() {
        return estimation;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id")
    public User getSender() {
        return sender;
    }

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    public User getRecipient() {
        return recipient;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}

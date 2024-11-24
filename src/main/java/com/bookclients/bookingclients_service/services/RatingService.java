package com.bookclients.bookingclients_service.services;

import java.util.UUID;

public interface RatingService {
    void recalculateRating();

    void addRating(Integer estimation, UUID senderId, UUID recipientId);
}

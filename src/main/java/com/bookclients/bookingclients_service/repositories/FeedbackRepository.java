package com.bookclients.bookingclients_service.repositories;

import java.util.List;
import java.util.UUID;

import com.bookclients.bookingclients_service.models.Feedback;

public interface FeedbackRepository {
    List<Feedback> findAllByServiceId(UUID serviceId);
}

package com.bookclients.bookingclients_service.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bookclients.bookingclients_service.models.Rating;

public interface RatingRepository {
    Rating save(Rating rating);

    Optional<List<Rating>> getAllRatingByUserId(UUID id);
}

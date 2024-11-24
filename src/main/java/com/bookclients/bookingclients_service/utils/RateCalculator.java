package com.bookclients.bookingclients_service.utils;

import com.bookclients.bookingclients_service.models.User;

public interface RateCalculator {
    float calculateRating(User user);
}

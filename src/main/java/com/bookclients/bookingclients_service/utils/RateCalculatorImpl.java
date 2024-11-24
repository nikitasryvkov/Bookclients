package com.bookclients.bookingclients_service.utils;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookclients.bookingclients_service.exceptions.rating.RatingNotFound;
import com.bookclients.bookingclients_service.models.Rating;
import com.bookclients.bookingclients_service.models.User;
import com.bookclients.bookingclients_service.repositories.RatingRepository;
import com.bookclients.bookingclients_service.repositories.UserRepository;

public class RateCalculatorImpl implements RateCalculator {

    private RatingRepository ratingRepository;
    private UserRepository userRepository;

    @Autowired
    public void setRateCalculatorImpl(RatingRepository ratingRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    public RateCalculatorImpl() {
    }

    public float calculateRating(User user) {
        UUID id = user.getId();
        List<Rating> receivedRating = ratingRepository.getAllRatingByUserId(id)
                .orElseThrow(() -> new RatingNotFound("Couldn't find rating for user with id: " + id));

        int sumEstimation = receivedRating.stream().mapToInt(Rating::getEstimation).sum();
        float score = sumEstimation / receivedRating.size();

        user.setRatingScore(score);
        userRepository.update(user);

        return score;
    }
}

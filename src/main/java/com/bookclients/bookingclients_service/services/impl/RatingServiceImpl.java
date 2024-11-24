package com.bookclients.bookingclients_service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bookclients.bookingclients_service.exceptions.rating.RatingNotFound;
import com.bookclients.bookingclients_service.exceptions.user.UserNotFoundException;
import com.bookclients.bookingclients_service.models.Rating;
import com.bookclients.bookingclients_service.models.User;
import com.bookclients.bookingclients_service.repositories.RatingRepository;
import com.bookclients.bookingclients_service.repositories.UserRepository;
import com.bookclients.bookingclients_service.services.RatingService;
import com.bookclients.bookingclients_service.utils.RateCalculatorImpl;

@Service
public class RatingServiceImpl implements RatingService {

    private RateCalculatorImpl rateCalculator;
    private RatingRepository ratingRepository;
    private UserRepository userRepository;

    @Autowired
    public RatingServiceImpl(RateCalculatorImpl rateCalculator, RatingRepository ratingRepository,
            UserRepository userRepository) {
        this.rateCalculator = rateCalculator;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Scheduled(fixedRateString = "${interval}")
    @Async
    public void recalculateRating() {
        List<UUID> usersId = userRepository.findAllId();

        for (UUID uuid : usersId) {
            User user = userRepository.findById(uuid)
                    .orElseThrow(() -> new UserNotFoundException("Не найден User с таким id: " + uuid));

            List<Rating> recipientId = ratingRepository.getAllRatingByUserId(uuid)
                    .orElseThrow(() -> new RatingNotFound("Рейтинг не найден для User с id: " + uuid));

            if (!recipientId.isEmpty()) {
                rateCalculator.calculateRating(user);
            }
        }
    }

    @Override
    public void addRating(Integer estimation, UUID senderId, UUID recipientId) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new UserNotFoundException("Не найден User с таким id:" + senderId));
        User received = userRepository.findById(recipientId)
                .orElseThrow(() -> new UserNotFoundException("Не найден User с таким id:" + recipientId));
        Rating rating = new Rating(estimation, sender, received);

        ratingRepository.save(rating);
    }
}

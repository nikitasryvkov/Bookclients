package com.bookclients.bookingclients_service.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookclients.bookingclients_service.services.RatingService;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/add")
    @ResponseBody
    public void addRating(@RequestParam(name = "uuidSender") UUID senderId,
            @RequestParam(name = "uuidRecipient") UUID recipientId,
            @RequestParam(name = "estimation") Integer estimation) {
        ratingService.addRating(estimation, senderId, recipientId);
    }

    @PostMapping("/recalculate")
    @ResponseBody
    public void recalculateRating() {
        ratingService.recalculateRating();
    }
}

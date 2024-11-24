package com.bookclients.bookingclients_service.services;

import java.util.UUID;

import com.bookclients.bookingclients_service.dtos.request.UserCreateDto;
import com.bookclients.bookingclients_service.dtos.request.UserUpdateRequestDto;
import com.bookclients.bookingclients_service.models.User;

public interface UserService {
    void calculateUserRating(User user);

    UserUpdateRequestDto updateUser(UUID id, UserUpdateRequestDto user);

    UserCreateDto createUser(UserCreateDto user);
}

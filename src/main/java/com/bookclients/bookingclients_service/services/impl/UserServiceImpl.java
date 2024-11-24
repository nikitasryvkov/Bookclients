package com.bookclients.bookingclients_service.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclients.bookingclients_service.dtos.request.user.UserCreateDTO;
import com.bookclients.bookingclients_service.dtos.request.user.UserUpdateRequestDTO;
import com.bookclients.bookingclients_service.exceptions.user.UserNotFoundException;
import com.bookclients.bookingclients_service.models.User;
import com.bookclients.bookingclients_service.repositories.UserRepository;
import com.bookclients.bookingclients_service.services.UserService;
import com.bookclients.bookingclients_service.utils.RateCalculatorImpl;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RateCalculatorImpl rateCalculator;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RateCalculatorImpl rateCalculator, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.rateCalculator = rateCalculator;
        this.modelMapper = modelMapper;
    }

    @Override
    public void calculateUserRating(User user) {
        rateCalculator.calculateRating(user);
    }

    @Override
    public UserUpdateRequestDTO updateUser(UUID id, UserUpdateRequestDTO user) {
        User userUpdate = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Не найден User с таким id: " + id));

        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userRepository.update(userUpdate);

        return modelMapper.map(userUpdate, UserUpdateRequestDTO.class);
    }

    @Override
    public UserCreateDTO createUser(UserCreateDTO user) {
        userRepository.save(modelMapper.map(user, User.class));
        return user;
    }
}

package com.bookclients.bookingclients_service.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookclients.bookingclients_service.dtos.request.user.UserCreateDTO;
import com.bookclients.bookingclients_service.dtos.request.user.UserUpdateRequestDTO;
import com.bookclients.bookingclients_service.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseBody
    public UserCreateDTO createUser(@RequestBody UserCreateDTO user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public UserUpdateRequestDTO updateUser(@PathVariable("id") UUID userId, @RequestBody UserUpdateRequestDTO user) {
        return userService.updateUser(userId, user);
    }
}

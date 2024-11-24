package com.bookclients.bookingclients_service.exceptions.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String massage) {
        super(massage);
    }
}

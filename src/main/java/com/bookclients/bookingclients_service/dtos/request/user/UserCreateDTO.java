package com.bookclients.bookingclients_service.dtos.request.user;

public class UserCreateDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String avatarURL;
    private String password;

    public UserCreateDTO(String firstName, String lastName, String username, String email, String phoneNumber,
            String avatarURL, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.avatarURL = avatarURL;
        this.password = password;
    }

    protected UserCreateDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.bookclients.bookingclients_service.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatarURL;
    private Float ratingScore;
    private Long count;
    private LocalDate registrationDate;
    private List<Authority> authorities = new ArrayList<>();

    public User(String firstName, String lastName, String username, String email, String password, String phoneNUmber,
            String avatarURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNUmber;
    }

    protected User() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Override
    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "avatar_url")
    public String getAvatarURL() {
        return avatarURL;
    }

    @Column(name = "rating_score")
    public Float getRatingScore() {
        return ratingScore;
    }

    @Column(name = "count_records")
    public Long getCount() {
        return count;
    }

    @Column(name = "registration_date")
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", targetEntity = Authority.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setRatingScore(Float ratingScore) {
        this.ratingScore = ratingScore;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}

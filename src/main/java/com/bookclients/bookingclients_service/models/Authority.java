package com.bookclients.bookingclients_service.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority extends BaseEntity implements GrantedAuthority {
    private String authority;
    private User user;

    public Authority(String authority) {
        this.authority = authority;
    }

    protected Authority() {
    }

    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    @Column(name = "authority_name")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

package com.aidar.data.model;

import com.aidar.data.enums.Role;
import com.aidar.data.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by paradise on 08.04.16.
 */
public class User {

    @JsonIgnore
    private long id;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String surname;

    private String email;

    private String password;

    private Role role;

    @JsonIgnore
    private UserStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getId() == user.getId();

    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}

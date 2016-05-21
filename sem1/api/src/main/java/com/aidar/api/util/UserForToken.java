package com.aidar.api.util;

import com.aidar.enums.Role;
import com.aidar.model.User;

/**
 * Created by paradise on 21.05.16.
 */
public class UserForToken {

    private String email;

    private String password;

    private Role role;

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

    public static UserForToken userToUserForToken(User user) {
        UserForToken userForToken = new UserForToken();
        userForToken.setEmail(user.getEmail());
        userForToken.setPassword(user.getPassword());
        userForToken.setRole(user.getRole());
        return userForToken;
    }

}

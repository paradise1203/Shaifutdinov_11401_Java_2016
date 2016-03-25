package com.aidar.o13;

import org.springframework.stereotype.Component;

/**
 * Created by paradise on 24.03.16.
 */
@Component
public class User {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

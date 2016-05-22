package com.aidar.web.util;

import com.aidar.web.data.model.User;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paradise on 17.05.16.
 */
public class ApiResponse {

    private HttpStatus httpStatus;

    private String token;

    private User user;

    private List<String> errors;

    public ApiResponse() {
        errors = new ArrayList<>();
    }

    public ApiResponse(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
        errors.add(error);
    }

}

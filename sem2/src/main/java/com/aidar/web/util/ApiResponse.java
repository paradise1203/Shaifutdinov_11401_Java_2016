package com.aidar.web.util;

import com.aidar.web.data.model.Community;
import com.aidar.web.data.model.Message;
import com.aidar.web.data.model.Request;
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

    private int rating;

    private List<Message> dialog;

    private User friend;

    private List<User> penFriends;

    private Community community;

    private boolean membership;

    private List<Community> communities;

    List<Request> requests;

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Message> getDialog() {
        return dialog;
    }

    public void setDialog(List<Message> dialog) {
        this.dialog = dialog;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public List<User> getPenFriends() {
        return penFriends;
    }

    public void setPenFriends(List<User> penFriends) {
        this.penFriends = penFriends;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public boolean isMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Community> communities) {
        this.communities = communities;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
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

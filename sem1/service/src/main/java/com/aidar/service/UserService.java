package com.aidar.service;

import com.aidar.model.User;

import java.util.List;

/**
 * Created by paradise on 11.04.16.
 */
public interface UserService {

    List<User> getAll();

    User getCurrent();

    void add(User user);

    void ban(String email);

    void pardon(String email);

}

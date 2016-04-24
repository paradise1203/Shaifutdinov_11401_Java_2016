package com.aidar.service;

import com.aidar.model.Request;

import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
public interface RequestService {

    List<Request> getAll();

    List<Request> getMy();

    List<Request> getPending();

    void add(Request request);

}

package com.aidar.service;

import com.aidar.model.Request;
import com.aidar.model.User;

import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
public interface RequestService {

    List<Request> getAll();

    List<Request> getRecent();

    List<Request> getMy();

    List<Request> getPending();

    List<Request> getClosedAsVolunteer(Long id);

    List<Request> getClosedAsNeedy(Long id);

    Request getOne(Long id);

    void add(Request request);

    void add(String address, String serviceType, User principal);

    void help(Long id);

    void close(Long id);

}

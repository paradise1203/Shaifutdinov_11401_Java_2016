package com.aidar.service;

import com.aidar.model.Community;

import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
public interface CommunityService {

    List<Community> getAll();

    void add(Community community);

}

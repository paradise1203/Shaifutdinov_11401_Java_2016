package com.aidar.service;

import com.aidar.model.Community;

import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
public interface CommunityService {

    List<Community> getAll();

    Community getOne(Long id);

    boolean isMember(Long id);

    void add(Community community);

    void addMember(Long id);

    void removeMember(Long id);

}

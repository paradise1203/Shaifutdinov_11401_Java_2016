package com.aidar.service.impl;

import com.aidar.model.Community;
import com.aidar.model.UserCommunity;
import com.aidar.repository.CommunityRepository;
import com.aidar.repository.UserCommunityRepository;
import com.aidar.service.CommunityService;
import com.aidar.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by paradise on 21.04.16.
 */
@Service
@Transactional
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private UserCommunityRepository userCommunityRepository;

    @Autowired
    private SecurityService securityService;

    @Override
    public List<Community> getAll() {
        return communityRepository.findAll();
    }

    @Override
    public Community getOne(Long id) {
        return communityRepository.findOne(id);
    }

    @Override
    public void add(Community community) {
        community.setFounder(securityService.getPersistedPrincipal());
        community.setCreatedAt(new Date());
        communityRepository.save(community);
    }

    @Override
    public void addMember(Long id) {
        UserCommunity userCommunity = new UserCommunity();
        userCommunity.setUser(securityService.getPersistedPrincipal());
        userCommunity.setCommunity(communityRepository.findOne(id));
        userCommunityRepository.save(userCommunity);
    }

}

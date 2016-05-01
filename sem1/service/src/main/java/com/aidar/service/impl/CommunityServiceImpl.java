package com.aidar.service.impl;

import com.aidar.model.Community;
import com.aidar.model.User;
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
    public boolean isMember(Long id) {
        User user = securityService.getPersistedPrincipal();
        Community community = communityRepository.findOne(id);
        return userCommunityRepository.findOneByUserAndCommunity(user, community) != null;
    }

    @Override
    public void add(Community community) {
        User user = securityService.getPersistedPrincipal();
        community.setFounder(user);
        community.setCreatedAt(new Date());
        communityRepository.save(community);
        userCommunityRepository.save(new UserCommunity(user, community));
    }

    @Override
    public void addMember(Long id) {
        User user = securityService.getPersistedPrincipal();
        Community community = communityRepository.findOne(id);
        if (userCommunityRepository.findOneByUserAndCommunity(user, community) == null) {
            UserCommunity userCommunity = new UserCommunity(user, community);
            userCommunityRepository.save(userCommunity);
        }
    }

    @Override
    public void removeMember(Long id) {
        User user = securityService.getPersistedPrincipal();
        Community community = communityRepository.findOne(id);
        UserCommunity userCommunity = userCommunityRepository.findOneByUserAndCommunity(user, community);
        userCommunityRepository.delete(userCommunity);
    }

}

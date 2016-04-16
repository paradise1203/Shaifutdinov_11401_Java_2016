package com.aidar.service.impl;

import com.aidar.model.user.SuperUser;
import com.aidar.repository.SuperUserRepository;
import com.aidar.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by paradise on 11.04.16.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SuperUserRepository superUserRepository;

    @Override
    public List<SuperUser> getAdmins() {
        return superUserRepository.findAll();
    }

}

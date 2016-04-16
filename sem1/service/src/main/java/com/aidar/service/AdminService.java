package com.aidar.service;

import com.aidar.model.user.SuperUser;

import java.util.List;

/**
 * Created by paradise on 11.04.16.
 */
public interface AdminService {

    List<SuperUser> getAdmins();

}

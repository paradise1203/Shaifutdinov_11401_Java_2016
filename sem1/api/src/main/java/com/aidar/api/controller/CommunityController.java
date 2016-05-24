package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.model.User;
import com.aidar.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 23.05.16.
 */
@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CommunityService communityService;

    @RequireAuthentication
    @RequestMapping("/{id}")
    public ApiResponse getInfo(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable("id") Long id) {
        User principal = authService.getPrincipal(request);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setUser(principal);
        apiResponse.setCommunity(communityService.getOne(id));
        apiResponse.setMembership(communityService.isMember(id, principal));
        return apiResponse;
    }

}

package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.api.util.CommunityValidator;
import com.aidar.model.User;
import com.aidar.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CommunityValidator communityValidator;

    @RequireAuthentication
    @RequestMapping("/all")
    public ApiResponse getAll(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setCommunities(communityService.getAll());
        return apiResponse;
    }

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

    @RequireAuthentication
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResponse newCommunity(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam("name") String name,
                                    @RequestParam("description") String description) {
        ApiResponse apiResponse = new ApiResponse();
        if (!communityValidator.validate(name, description, apiResponse)) {
            return apiResponse;
        }
        communityService.add(name, description, authService.getPrincipal(request));
        apiResponse.setHttpStatus(HttpStatus.OK);
        return apiResponse;
    }

}

package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.enums.Role;
import com.aidar.model.User;
import com.aidar.service.AssessmentService;
import com.aidar.service.CommunityService;
import com.aidar.service.MessageService;
import com.aidar.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by paradise on 17.05.16.
 */
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private AssessmentService assessmentService;

    @RequireAuthentication
    @RequestMapping("/profile")
    public ApiResponse profile(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setUser(authService.getPrincipal(request));
        return apiResponse;
    }

    @RequireAuthentication
    @RequestMapping("/home")
    public ApiResponse home(HttpServletRequest request, HttpServletResponse response) {
        User principal = authService.getPrincipal(request);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setUser(principal);
        if (principal.getRole() == Role.ROLE_USER) {
            apiResponse.setPenFriends(new ArrayList<>(messageService.getMyPenFriends(principal)));
            apiResponse.setCommunities(new ArrayList<>(communityService.getMy(principal)));
            apiResponse.setRating(assessmentService.getMyRating(principal));
        } else if (principal.getRole() == Role.ROLE_ADMIN) {
            apiResponse.setCommunities(communityService.getRecent());
            apiResponse.setRequests(requestService.getRecent());
        }
        return apiResponse;
    }

}

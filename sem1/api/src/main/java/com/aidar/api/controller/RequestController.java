package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 25.05.16.
 */
@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RequestService requestService;

    @RequireAuthentication
    @RequestMapping("/all")
    public ApiResponse getAll(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setRequests(requestService.getAll());
        return apiResponse;
    }

}

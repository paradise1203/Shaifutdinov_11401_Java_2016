package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.api.util.RequestValidator;
import com.aidar.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private RequestValidator requestValidator;

    @RequireAuthentication
    @RequestMapping("/all")
    public ApiResponse getAll(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setRequests(requestService.getAll());
        return apiResponse;
    }

    @RequireAuthentication
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResponse newRequest(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("address") String address,
                                  @RequestParam("serviceType") String serviceType) {
        ApiResponse apiResponse = new ApiResponse();
        if (!requestValidator.validate(address, apiResponse)) {
            return apiResponse;
        }
        requestService.add(address, serviceType, authService.getPrincipal(request));
        apiResponse.setHttpStatus(HttpStatus.OK);
        return apiResponse;
    }

}

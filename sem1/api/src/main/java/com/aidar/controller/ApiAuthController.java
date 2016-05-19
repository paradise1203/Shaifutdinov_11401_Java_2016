package com.aidar.controller;

import com.aidar.security.AuthService;
import com.aidar.security.annotation.RequireAnonymous;
import com.aidar.util.ApiResponse;
import com.aidar.util.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 15.05.16.
 */
@RestController
@RequestMapping("/api")
public class ApiAuthController {

    @Autowired
    private AuthService authService;

    @RequireAnonymous
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ApiResponse signIn(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            apiResponse.setResponseData(authService.addToken(request));
            apiResponse.setHttpResponse(HttpResponse.SUCCESS);
        } catch (AuthenticationException ex) {
            apiResponse.setHttpResponse(HttpResponse.FAIL);
            apiResponse.addError(ex.getMessage());
        }
        return apiResponse;
    }

}
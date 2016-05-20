package com.aidar.api.controller;

import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.api.util.ApiResponse;
import com.aidar.api.util.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 17.05.16.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequireAuthentication
    @RequestMapping("/home")
    public ApiResponse home(HttpServletRequest request, HttpServletResponse response) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpResponse(HttpResponse.SUCCESS);
        apiResponse.setResponseData("Home page!");
        return apiResponse;
    }

}

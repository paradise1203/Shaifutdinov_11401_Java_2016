package com.aidar.controller;

import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.aidar.security.annotation.RequireAuthentication;
import com.aidar.util.ApiResponse;
import com.aidar.util.HttpResponse;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
>>>>>>> 0370696ee389c4b1a4e37a4b00165debd23946f4
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

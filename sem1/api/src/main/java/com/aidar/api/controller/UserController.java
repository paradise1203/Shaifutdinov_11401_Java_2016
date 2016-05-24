package com.aidar.api.controller;

import com.aidar.api.rest.ApiResponse;
import com.aidar.api.security.AuthService;
import com.aidar.api.security.annotation.RequireAuthentication;
import com.aidar.service.MessageService;
import com.aidar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paradise on 24.05.16.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequireAuthentication
    @RequestMapping("/{id}/dialog")
    public ApiResponse dialog(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable("id") Long id) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK);
        apiResponse.setDialog(messageService.getDialog(id, authService.getPrincipal(request)));
        apiResponse.setFriend(userService.getOne(id));
        return apiResponse;
    }

    @RequireAuthentication
    @RequestMapping(value = "/{id}/dialog", method = RequestMethod.POST)
    public ApiResponse sendNewMessage(HttpServletRequest request, HttpServletResponse response,
                                      @PathVariable("id") Long id,
                                      @RequestParam("text") String text) {
        messageService.add(id, text, authService.getPrincipal(request));
        return new ApiResponse(HttpStatus.OK);
    }

}

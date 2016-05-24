package com.aidar.web.service;

import com.aidar.web.util.ApiResponse;

/**
 * Created by paradise on 19.05.16.
 */
public interface HelpApiService {

    ApiResponse signIn(String email, String pass);

    ApiResponse profile();

    ApiResponse home();

    ApiResponse community(Long id);

}

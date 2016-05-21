package com.aidar.web;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by paradise on 19.05.16.
 */
public class HelpApiServiceImpl implements HelpApiService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ApiResponse<String> signIn(String email, String pass) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("email", email);
        params.add("pass", pass);
        return restTemplate.postForObject("http://localhost:8080/api/sign_in", params, ApiResponse.class);
    }

}

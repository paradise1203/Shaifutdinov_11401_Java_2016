package com.aidar.web.service.impl;

import com.aidar.app.Main;
import com.aidar.web.service.HelpApiService;
import com.aidar.web.util.ApiResponse;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by paradise on 19.05.16.
 */
@Service
@PropertySource("classpath:apiurl.properties")
public class HelpApiServiceImpl implements HelpApiService {

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    private static final String TOKEN = "token";

    @Override
    public ApiResponse signIn(String email, String pass) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("email", email);
        params.add("pass", pass);
        return restTemplate.postForObject(environment.getProperty("signIn"), params, ApiResponse.class);
    }

    private ApiResponse restCall(String url) {
        try {
            URI uri = new URIBuilder(url)
                    .addParameter(TOKEN, Main.token)
                    .build();
            return restTemplate.getForObject(uri, ApiResponse.class);
        } catch (URISyntaxException ignored) {
            return null;
        }
    }

    @Override
    public ApiResponse profile() {
        return restCall(environment.getProperty("profile"));
    }

    @Override
    public ApiResponse home() {
        return restCall(environment.getProperty("homePage"));
    }

    @Override
    public ApiResponse community(Long id) {
        return restCall(environment.getProperty("community") + "/" + id);
    }

}

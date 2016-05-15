package com.aidar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paradise on 15.05.16.
 */
@RestController
@PropertySource("classpath:api.properties")
public class ApiController {

    @Autowired
    private Environment environment;

    @RequestMapping("/api")
    public String api() {
        return environment.getProperty("tokenSecret");
    }

}

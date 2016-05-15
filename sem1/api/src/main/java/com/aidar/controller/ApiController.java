package com.aidar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paradise on 15.05.16.
 */
@RestController
public class ApiController {

    @RequestMapping("/api")
    public String api() {
        return "Hello, world!";
    }

}

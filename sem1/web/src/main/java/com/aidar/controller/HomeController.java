package com.aidar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by paradise on 06.04.16.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String defaultPath() {
        return "home";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}

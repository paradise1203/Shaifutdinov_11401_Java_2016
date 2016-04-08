package com.aidar.controller;

import com.aidar.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by paradise on 06.04.16.
 */
@Controller
public class MainController {

    @Autowired
    private SomeService someService;

    @RequestMapping("/some")
    public String some() {
        System.out.println(someService.getSomeEntities());
        return "some";
    }

}

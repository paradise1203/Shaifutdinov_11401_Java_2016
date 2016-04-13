package com.aidar.controller;

import com.aidar.service.UserService;
import com.aidar.util.UserRegistrationForm;
import com.aidar.util.UserRegistrationFormToUserTransformer;
import com.aidar.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by paradise on 06.04.16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/new")
    public String getNew() {
        return "users_new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute UserRegistrationForm userRegistrationForm,
                             BindingResult result) {
        userValidator.validate(userRegistrationForm, result);
        if (result.hasErrors()) {
            return "users_new";
        }
        userService.addUser(UserRegistrationFormToUserTransformer
                .transform(userRegistrationForm));
        return "redirect:/auth/login";
    }

}

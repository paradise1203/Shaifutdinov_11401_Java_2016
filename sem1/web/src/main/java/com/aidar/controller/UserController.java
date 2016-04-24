package com.aidar.controller;

import com.aidar.model.User;
import com.aidar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by paradise on 17.04.16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/edit")
    public String getEditPage(Model model) {
        model.addAttribute("user", userService.getCurrent());
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/home";
    }

    @RequestMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/ban", method = RequestMethod.POST)
    @ResponseBody
    public void banUser(@RequestParam("email") String email) {
        userService.ban(email);
    }

    @RequestMapping(value = "/pardon", method = RequestMethod.POST)
    @ResponseBody
    public void pardonUser(@RequestParam("email") String email) {
        userService.pardon(email);
    }

}

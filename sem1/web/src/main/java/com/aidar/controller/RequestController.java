package com.aidar.controller;

import com.aidar.enums.ServiceType;
import com.aidar.model.Request;
import com.aidar.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by paradise on 24.04.16.
 */
@Controller
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping("")
    public String getRequestsPage(Model model) {
        model.addAttribute("requests", requestService.getAll());
        return "requests";
    }

    @RequestMapping("/all")
    @ResponseBody
    public ModelAndView getAll(Model model) {
        model.addAttribute("requests", requestService.getAll());
        return new ModelAndView("portion/requests_all");
    }

    @RequestMapping("/my")
    @ResponseBody
    public ModelAndView getMy(Model model) {
        model.addAttribute("requests", requestService.getMy());
        return new ModelAndView("portion/requests_all");
    }

    @RequestMapping("/pending")
    @ResponseBody
    public ModelAndView getPending(Model model) {
        model.addAttribute("requests", requestService.getPending());
        return new ModelAndView("portion/requests_all");
    }

    @RequestMapping("/new")
    public String getNewForm(Model model) {
        model.addAttribute("serviceTypes", ServiceType.values());
        model.addAttribute("request", new Request());
        return "request";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String sendNewForm(@ModelAttribute("request") Request request) {
        requestService.add(request);
        return "redirect:/home";
    }

}

package com.aidar.controller;

import com.aidar.service.AssessmentService;
import com.aidar.service.CommunityService;
import com.aidar.service.MessageService;
import com.aidar.util.MyAssessments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by paradise on 06.04.16.
 */
@Controller
public class HomeController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private AssessmentService assessmentService;

    @RequestMapping("/")
    public String defaultPath() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("penFriends", messageService.getMyPenFriends());
        model.addAttribute("communities", communityService.getMy());
        model.addAttribute("assessments", new MyAssessments(assessmentService.getMy()));
        return "user/home";
    }

}

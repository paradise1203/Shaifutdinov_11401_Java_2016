package com.aidar.controller;

import com.aidar.model.Community;
import com.aidar.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by paradise on 24.04.16.
 */
@Controller
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping(value = "")
    public String getAllCommunities(Model model) {
        model.addAttribute("communities", communityService.getAll());
        return "community/communities";
    }

    @RequestMapping(value = "/{id}")
    public String getInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("community", communityService.getOne(id));
        return "community/community";
    }

    @RequestMapping(value = "/{id}/subscribe", method = RequestMethod.POST)
    @ResponseBody
    public void subscribe(@PathVariable("id") Long id) {
        communityService.addMember(id);
    }

    @RequestMapping(value = "/{id}/unsubscribe", method = RequestMethod.POST)
    @ResponseBody
    public void unsubscribe(@PathVariable("id") Long id) {
        communityService.removeMember(id);
    }

    @RequestMapping(value = "/new")
    public String getNewCommunityForm(Model model) {
        model.addAttribute("community", new Community());
        return "community/new_community";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addNewCommunity(@ModelAttribute("community") Community community) {
        communityService.add(community);
        return "redirect:/home";
    }

}

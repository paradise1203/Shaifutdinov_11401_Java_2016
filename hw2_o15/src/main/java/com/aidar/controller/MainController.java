package com.aidar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by paradise on 24.03.16.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String root() {
        return "redirect:/process";
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String getProcess() {
        return "process";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String postProcess(HttpServletRequest request, Model model) {
        String text = request.getParameter("text");
        int count;
        switch (Integer.valueOf(request.getParameter("operation"))) {
            case 0:
                count = text.length();
                break;
            case 1:
                count = text.split("\\s+").length;
                break;
            case 2:
                count = text.split("\\.").length;
                break;
            default:
                count = text.split("[\\n]").length;
        }
        return "redirect:/result?count=" + count;
    }

    @RequestMapping("/result")
    public String result(@RequestParam(value = "count", required = false) String count, Model model) {
        if (count == null) {
            return "redirect:/process";
        }
        model.addAttribute("result", count);
        return "result";
    }

}

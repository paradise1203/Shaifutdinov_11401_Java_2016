package com.aidar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * Created by paradise on 24.03.16.
 */
@Controller
public class MainController {

    @RequestMapping("/getdate")
    public String getDate(Model model) {
        model.addAttribute("dateTime", LocalDateTime.now().toString());
        return "getdate";
    }

    @RequestMapping("/{operation}/{num1}/{num2}")
    public String mathOperation(@PathVariable("operation") String operation,
                                @PathVariable("num1") int num1, @PathVariable("num2") int num2, Model model) {
        switch (operation) {
            case "add":
                model.addAttribute("res", num1 + num2);
                break;
            case "mult":
                model.addAttribute("res", num1 * num2);
                break;
            default:
                return "redirect:/error";
        }
        return "operation";
    }

    @RequestMapping("/{address}/search")
    public String search(@PathVariable("address") String address, Model model) {
        StringBuilder url = new StringBuilder("http://");
        String param;
        switch (address) {
            case "yahoo.com":
                url.append("search.").append(address).append("/search;");
                param = "p";
                break;
            case "aol.com":
                url.append("search.").append(address).append("/aol/search");
                param = "q";
                break;
            case "bing.com":
                url.append(address).append("/search");
                param = "q";
                break;
            case "baidu.com":
                url.append(address).append("/s");
                param = "wd";
                break;
            default:
                return "redirect:/error";
        }
        model.addAttribute("url", url);
        model.addAttribute("param", param);
        return "search";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

}

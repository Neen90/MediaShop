package com.vdab.mediashop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping(value = "/")
    public String showHomePage() {
        return "index";
    }
}

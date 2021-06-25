package com.vdab.mediashop.controllers;

import com.vdab.mediashop.services.LPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LPController {
    @Autowired
    private LPService lpService;

    @GetMapping(value ="/lps")
    private String showLPPage(Model model){
        model.addAttribute("alllps",lpService.getAllLPs());
        return "lps";
    }
}

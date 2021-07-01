package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.domain.LP;
import com.vdab.mediashop.domain.LPGenre;
import com.vdab.mediashop.services.LPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LPController {
    @Autowired
    private LPService lpService;

    @GetMapping(value ="/lps")
    private String showLPPage(Model model){
        model.addAttribute("alllps",lpService.getAllLPs());
        return "lps";
    }
    @GetMapping(value = "addLp")
    public String showAddLpForm(Model model){
        model.addAttribute("newLps",new Game());
        model.addAttribute("lPGenre", LPGenre.values());
        return "addlp";
    }
    @PostMapping(value = "saveLp")
            public String saveLp(@ModelAttribute LP newLP){
    lpService.saveLp(newLP);
    return"redirect:/lps";
}
    @GetMapping(value ="/editLP/{id}")
    public String showEditLPPage(@PathVariable("id")long id, Model model){
        model.addAttribute("editLP",lpService.findLPById(id));
        model.addAttribute("lPGenre", LPGenre.values());
        return "editlp";
    }
    @PostMapping(value = "/editedLP/{id}")
    public String editedLP(@ModelAttribute LP lp){
        lpService.updateLP(lp);
        return "redirect:/lps";
    }
    @GetMapping(value = "deleteLP/{id}")
    public String deleteLP(@PathVariable("id")long id){
        lpService.deleteLP(id);
        return "redirect:/lps";
    }
}
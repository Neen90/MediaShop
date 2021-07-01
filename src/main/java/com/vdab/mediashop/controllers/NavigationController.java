package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.Users;
import com.vdab.mediashop.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavigationController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showHomePage() {
        return "index";
    }

//
//    @GetMapping(value = "/loginPage")
//    public String showLoginPage(){
//        return "login";
//    }
    @GetMapping(value = "/signup")
    public String showSignupPage(Model model){
        model.addAttribute("newUser",new Users());
        return "signup";
    }
    @PostMapping(value = "/saveNewUser")
    public String saveNewUser(@ModelAttribute User newUser){
        userService.saveNewUser(newUser);
        return "redirect:/productoverview";
    }


}

package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.Users;
import com.vdab.mediashop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;

@Controller
public class NavigationController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showHomePage() {
        return "index";
    }


    @GetMapping(value = "/login")
    public String showLoginPage(Model model){
        model.addAttribute("allusers",userService.getUsers());
        model.addAttribute("loggedInUser", new Users());
        return "login";
    }
   @PostMapping(value = "/loggedin")
    public String showLoggedIn(@ModelAttribute Users loggedInUser, HttpSession session){
       loggedInUser = userService.findById(loggedInUser.getId());
       session.setAttribute("loggedInUser", loggedInUser);
            userService.updateLoginValue(loggedInUser.getId());
            return "redirect:/productoverview";
        }


    @GetMapping(value = "/signup")
    public String showSignupPage(Model model){
        model.addAttribute("newUser",new Users());
        return "signup";
    }
    @PostMapping(value = "/saveNewUser")
    public String saveNewUser(@ModelAttribute Users newUser){
        userService.saveNewUser(newUser);
        return "redirect:/productoverview";
    }


}

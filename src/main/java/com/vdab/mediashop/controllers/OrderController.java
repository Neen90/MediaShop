package com.vdab.mediashop.controllers;

import com.vdab.mediashop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/basket")
    public String showBasketPage(){
        return "basket";
    }
//    @GetMapping(value = "/orderarticle/{id}")
//    public String

}

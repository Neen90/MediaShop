package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.*;
import com.vdab.mediashop.services.ArticleService;
import com.vdab.mediashop.services.GameService;
import com.vdab.mediashop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/basket")
    public String showBasketPage(){
        return "basket";
    }

    @GetMapping(value = "/addToBasket")
    public String AddToBasket(@ModelAttribute("orderedGame")Game game, Model model){
        Game foundGame = (Game) model.getAttribute("orderedGame");

        model.addAttribute("orderedGame",articleService.findArticleById(foundGame));
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(1);
        orderLine.setArticleId(foundGame.getId());
        orderLine.setCurrentPrice(foundGame.getPrice());

        Orders order = new Orders();
        order.getOrderLines().add(orderLine);
//        order.setOrderDate(LocalDate.now());

        model.addAttribute("newOrder",order);

        return "redirect:/basket";
    }
//    @GetMapping(value = "AddToBasket/{id}")
//    public String(@PathVariable("id") long id,Model model){
//        model.addAttribute("gameChoice",gameService.findGameById(id));
//        model.addAttribute("orderGame",new OrderLine());
////        OrderLine orderLine=new OrderLine();
////        orderLine.setArticleId();
////        orderLine.setQuantity(1);
////        orderLine.setCurrentPrice();

//    }



//    @PostMapping(value ="/orderedArticle/{id}")
//    public String OrderingArticle(@ModelAttribute OrderLine newOrderLine){
//        orderService.saveNewOrderLine(newOrderLine);
//        return "redirect:/basket";
//    }
}

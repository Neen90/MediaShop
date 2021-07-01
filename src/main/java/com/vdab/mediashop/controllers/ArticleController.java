package com.vdab.mediashop.controllers;

import com.vdab.mediashop.services.ArticleService;
import com.vdab.mediashop.services.BookService;
import com.vdab.mediashop.services.GameService;
import com.vdab.mediashop.services.LPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GameService gameService;
    @Autowired
    private LPService lpService;
    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/productoverview")
    public String showOverviewPage(Model model){
        model.addAttribute("allArticles",articleService.getAllArticles());
        model.addAttribute("allGames",gameService.getAllGames());
        model.addAttribute("alllps",lpService.getAllLPs());
        model.addAttribute("allBooks",bookService.getAllBooks());
        return "productoverview";
    }
}

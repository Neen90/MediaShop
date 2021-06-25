package com.vdab.mediashop.controllers;

import com.vdab.mediashop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public String showBooksPage(Model model){
        //model.addAttribute("allbooks", bookService.getAllBooks());
        model.addAttribute("allFictbooks", bookService.getAllFictBooks());
        model.addAttribute("allNonFictbooks", bookService.getAllNonFictBooks());
        return "books";
    }
}

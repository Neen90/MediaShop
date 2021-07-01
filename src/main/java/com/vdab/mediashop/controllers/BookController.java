package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.BookGenre;
import com.vdab.mediashop.domain.Fiction;
import com.vdab.mediashop.domain.NonFiction;
import com.vdab.mediashop.domain.Subject;
import com.vdab.mediashop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public String showBooksPage(Model model) {
        //model.addAttribute("allbooks", bookService.getAllBooks());
        model.addAttribute("allFictbooks", bookService.getAllFictBooks());
        model.addAttribute("allNonFictbooks", bookService.getAllNonFictBooks());
        return "books";
    }

    @GetMapping(value = "addFiction")
    public String showAddFictionPage(Model model) {
        model.addAttribute("newFiction", new Fiction());
        model.addAttribute("bookGenre", BookGenre.values());
        return "addfiction";
    }

    @PostMapping(value = "saveFiction")
    public String saveFiction(@ModelAttribute Fiction newFiction) {
        bookService.saveFiction(newFiction);
        return "redirect:/books";
    }

    @GetMapping(value = "addNonFiction")
    public String showAddNonFictionPage(Model model) {
        model.addAttribute("newNonFiction", new NonFiction());
        model.addAttribute("subject", Subject.values());
        return "addnonfiction";
    }

    @PostMapping(value = "saveNonFiction")
    public String saveNonFiction(@ModelAttribute NonFiction newNonFiction) {
        bookService.saveNonFiction(newNonFiction);
        return "redirect:/books";
    }

    @GetMapping(value = "/editFiction/{id}")
    public String showEditFictionPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("editFiction", bookService.findFictionById(id));
        model.addAttribute("bookGenre", BookGenre.values());
        return "editfiction";
    }

    @PostMapping(value = "/editedFiction/{id}")
    public String editedFiction(@ModelAttribute Fiction fiction) {
        bookService.updateFiction(fiction);
        return "redirect:/books";
    }

    @GetMapping(value = "/editNonFiction/{id}")
    public String showEditNonFictionPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("editNonFiction", bookService.findNonFictionById(id));
        model.addAttribute("subject", Subject.values());
        return "editnonfiction";
    }

    @PostMapping(value = "/editedNonFiction/{id}")
    public String editedNonFiction(@ModelAttribute NonFiction nonFiction) {
        bookService.updateNonFiction(nonFiction);
        return "redirect:/books";

    }

    @GetMapping(value = "/deleteFiction/{id}")
    public String deleteFiction(@PathVariable("id") long id) {
        bookService.deleteFiction(id);
        return "redirect:/books";
    }

    @GetMapping(value = "/deleteNonFiction/{id}")
    public String deleteNonFiction(@PathVariable("id") long id) {
        bookService.deleteNonFiction(id);
        return "redirect:/books";

    }
}
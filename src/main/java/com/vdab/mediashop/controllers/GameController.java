package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;


    @GetMapping(value ="/games")
    public String showGamesPage(Model model){
        model.addAttribute("allGames",gameService.getAllGames());
        return "games";
    }
    @GetMapping(value = "/addGame")
    public String showAddGameForm(Model model){
        model.addAttribute("newGame",new Game());
        return "addgame";
    }

    @PostMapping(value = "saveGame")
    public String saveGame(@ModelAttribute Game newGame){
        gameService.saveGame(newGame);
        return "redirect:/games";
    }
}

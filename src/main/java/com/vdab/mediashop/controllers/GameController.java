package com.vdab.mediashop.controllers;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.domain.GameGenre;
import com.vdab.mediashop.domain.Subject;
import com.vdab.mediashop.services.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("gameGenre", GameGenre.values());
        return "addgame";
    }

    @PostMapping(value = "saveGame")
    public String saveGame(@ModelAttribute Game newGame){
        gameService.saveGame(newGame);
        return "redirect:/games";
    }
    @GetMapping(value = "/editGame/{id}")
    public String showEditGamePage(@PathVariable("id") long id,Model model){
        model.addAttribute("editGame",gameService.findGameById(id));
        model.addAttribute("gameGenre", GameGenre.values());
        return "editgame";
    }
    @PostMapping(value = "/editedGame/{id}")
    public String editedGame(@ModelAttribute Game game){
        gameService.updateGame(game);
        return "redirect:/games";
    }
    @GetMapping(value = "/deleteGame/{id}")
    public String deleteGame(@PathVariable("id")long id){
        gameService.deleteGame(id);
        return "redirect:/games";
    }
}

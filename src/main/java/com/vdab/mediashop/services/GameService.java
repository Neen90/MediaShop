package com.vdab.mediashop.services;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.getAllGames();
    }

    public void saveGame(Game newGame) {
        gameRepository.saveGame(newGame);
    }
}

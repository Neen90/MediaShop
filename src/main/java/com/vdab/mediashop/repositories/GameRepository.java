package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GameRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> getAllGames() {
        TypedQuery<Game> games = entityManager.createQuery("select g from Game g",Game.class);
        return games.getResultList();
    }
    @Transactional(rollbackOn = Exception.class)
    public void saveGame(Game newGame) {
        entityManager.persist(newGame);
    }

    public Game findGameById(long id) {
        return entityManager.find(Game.class, id);
    }
    @Transactional
    public void updateGame(Game game) {
        entityManager.merge(game);
    }
    @Transactional
    public void deleteGame(long id) {
        Game game = findGameById(id);
        entityManager.remove(game);
    }
}

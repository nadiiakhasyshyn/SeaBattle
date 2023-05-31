package com.example.seabattle.controllers;

import com.example.seabattle.api.models.GameApiModel;
import com.example.seabattle.models.GameModel;
import com.example.seabattle.repositories.IGameRepository;
import com.example.seabattle.services.impl.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;
    @Autowired
    public GameController(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping
    public ResponseEntity<GameModel> createGame(@RequestBody GameApiModel game) {
        GameModel createdGame = gameRepository.save(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameModel> getGame(@PathVariable("id") long id) {
        GameModel game = gameRepository.findById(id).orElse(null);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameModel> updateGame(@PathVariable("id") long id, @RequestBody GameModel game) {
        GameModel existingGame = gameRepository.findById(id).orElse(null);
        if (existingGame != null) {
            existingGame.setName(game.getName());
            existingGame.setGameWithFriend(game.isGameWithFriend());
            existingGame.setBoardModels(game.getBoardModels());
            existingGame.setGameState(game.getGameState());

            GameModel updatedGame = gameRepository.save(existingGame);
            return new ResponseEntity<>(updatedGame, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") long id) {
        GameModel game = gameRepository.findById(id).orElse(null);
        if (game != null) {
            gameRepository.delete(game);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


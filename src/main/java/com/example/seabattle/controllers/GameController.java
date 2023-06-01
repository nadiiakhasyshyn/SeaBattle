package com.example.seabattle.controllers;

import com.example.seabattle.api.models.GameApiModel;
import com.example.seabattle.services.IGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/game")
public class GameController {
    private final IGameService gameService;
    public GameController(IGameService gameService) {
        super();
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameApiModel> createGame(@RequestBody GameApiModel game) {
        GameApiModel createdGame = gameService.create(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GameApiModel>> getAllGames() {
        List<GameApiModel> boards = gameService.getAll();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameApiModel> getGame(@PathVariable("id") long id) {
        GameApiModel game = gameService.getById(id);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<GameApiModel> updateGame(@RequestBody GameApiModel game) {
        GameApiModel updatedGame = gameService.update(game);
        if (updatedGame != null) {
            return new ResponseEntity<>(updatedGame, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GameApiModel> deleteGame(@PathVariable("id") long id) {
        GameApiModel game = gameService.delete(id);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


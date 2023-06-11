package com.example.seabattle.controllers;

import com.example.seabattle.api.models.PlayerApiModel;
import com.example.seabattle.services.IPlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final IPlayerService playerService;

    public PlayerController(IPlayerService playerService) {
        super();
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerApiModel> createPlayer(@RequestBody PlayerApiModel player) {
        PlayerApiModel createdPlayer = playerService.create(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerApiModel>> getAllPlayers() {
        List<PlayerApiModel> players = playerService.getAll();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerApiModel> getPlayer(@PathVariable("id") long id) {
        PlayerApiModel player = playerService.getById(id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerApiModel> deletePlayer(@PathVariable("id") long id) {
        PlayerApiModel player = playerService.delete(id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PlayerApiModel> getPlayerByName(@PathVariable("name") String name) {
        PlayerApiModel player = playerService.getByName(name);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<PlayerApiModel> updatePlayerByName(@PathVariable("name") String name, @RequestBody PlayerApiModel player) {
        PlayerApiModel updatedPlayer = playerService.updateByName(name, player);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

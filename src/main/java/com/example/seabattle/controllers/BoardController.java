package com.example.seabattle.controllers;

import com.example.seabattle.api.models.BoardApiModel;
import com.example.seabattle.services.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/board")
public class BoardController {
    private final IBoardService boardService;

    @Autowired
    public BoardController(IBoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardApiModel> createBoard(@RequestBody BoardApiModel board) {
        BoardApiModel myBoard = boardService.create(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(myBoard);
    }

    @GetMapping
    public ResponseEntity<List<BoardApiModel>> getAllBoards() {
        List<BoardApiModel> boards = boardService.getAll();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardApiModel> getBoardById(@PathVariable("id") long id) {
        BoardApiModel board = boardService.getById(id);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<BoardApiModel> updateBoard(@RequestBody BoardApiModel board) {
        BoardApiModel updatedBoard = boardService.update(board);
        if (updatedBoard != null) {
            return new ResponseEntity<>(updatedBoard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardApiModel> deleteBoard(@PathVariable("id") long id) {
        BoardApiModel board = boardService.delete(id);
        if (board != null) {
            return new ResponseEntity<>(board, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

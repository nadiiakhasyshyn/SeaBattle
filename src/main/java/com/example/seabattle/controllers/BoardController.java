package com.example.seabattle.controllers;

import com.example.seabattle.api.models.BoardApiModel;
import com.example.seabattle.models.BoardModel;
import com.example.seabattle.services.impl.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardApiModel> createBoard(@RequestBody BoardApiModel board) {
        BoardApiModel myBoard = boardService.createBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(myBoard);
    }

    @GetMapping
    public ResponseEntity<List<BoardModel>> getAllBoards() {
        List<BoardModel> boards = boardService.getAllBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardModel> getBoardById(@PathVariable("id") long id) {
        BoardModel board = boardService.getBoardById(id);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Додаткові методи, якщо потрібно

    // Приклад іншого методу:
}

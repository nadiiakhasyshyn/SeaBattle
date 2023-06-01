package com.example.seabattle.controllers;

import com.example.seabattle.api.models.CellApiModel;
import com.example.seabattle.services.ICellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cell")
public class CellController {
    private final ICellService cellService;

    @Autowired
    public CellController(ICellService cellService) {
        this.cellService = cellService;
    }

    @PostMapping
    public ResponseEntity<CellApiModel> createCell(@RequestBody CellApiModel model) {
        CellApiModel cell = cellService.create(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(cell);
    }

    @GetMapping
    public ResponseEntity<List<CellApiModel>> getAllCells() {
        List<CellApiModel> cells = cellService.getAll();
        return ResponseEntity.ok(cells);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CellApiModel> getCellById(@PathVariable("id") long id) {
        CellApiModel cell = cellService.getById(id);
        if (cell != null) {
            return ResponseEntity.ok(cell);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<CellApiModel> updateCell(@RequestBody CellApiModel cell) {
        CellApiModel updatedCell = cellService.update(cell);
        if (updatedCell != null) {
            return new ResponseEntity<>(updatedCell, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CellApiModel> deleteCell(@PathVariable("id") long id) {
        CellApiModel cell = cellService.delete(id);
        if (cell != null) {
            return new ResponseEntity<>(cell, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

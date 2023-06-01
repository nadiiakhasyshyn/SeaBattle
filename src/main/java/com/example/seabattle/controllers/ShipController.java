package com.example.seabattle.controllers;

import com.example.seabattle.api.models.ShipApiModel;
import com.example.seabattle.services.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/ship")
public class ShipController {
    private final IShipService shipService;

    @Autowired
    public ShipController(IShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping
    public ResponseEntity<ShipApiModel> createShip(@RequestBody ShipApiModel ship) {
        ShipApiModel shipModel = shipService.create(ship);
        return ResponseEntity.status(HttpStatus.CREATED).body(shipModel);
    }

    @GetMapping
    public ResponseEntity<List<ShipApiModel>> getAllShips() {
        List<ShipApiModel> ships = shipService.getAll();
        return ResponseEntity.ok(ships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipApiModel> getShipById(@PathVariable("id") long id) {
        ShipApiModel ship = shipService.getById(id);
        if (ship != null) {
            return ResponseEntity.ok(ship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<ShipApiModel> updateShip(@RequestBody ShipApiModel ship) {
        ShipApiModel updatedShip = shipService.update(ship);
        if (updatedShip != null) {
            return new ResponseEntity<>(updatedShip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShipApiModel> deleteShip(@PathVariable("id") long id) {
        ShipApiModel ship = shipService.delete(id);
        if (ship != null) {
            return new ResponseEntity<>(ship, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.seabattle.controllers;

import com.example.seabattle.models.ShipModel;
import com.example.seabattle.repositories.IShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/ship")
public class ShipController {
    private final IShipRepository shipRepository;

    @Autowired
    public ShipController(IShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @PostMapping
    public ResponseEntity<ShipModel> createShip(@RequestBody ShipModel ship) {
        ShipModel createdShip = shipRepository.save(ship);
        return new ResponseEntity<>(createdShip, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipModel> getShip(@PathVariable("id") long id) {
        ShipModel ship = shipRepository.findById(id).orElse(null);
        if (ship != null) {
            return new ResponseEntity<>(ship, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipModel> updateShip(@PathVariable("id") long id, @RequestBody ShipModel ship) {
        ShipModel existingShip = shipRepository.findById(id).orElse(null);
        if (existingShip != null) {
            existingShip.setName(ship.getName());
            existingShip.setSize(ship.getSize());
            existingShip.setHits(ship.getHits());
            existingShip.setBoard(ship.getBoard());

            ShipModel updatedShip = shipRepository.save(existingShip);
            return new ResponseEntity<>(updatedShip, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShip(@PathVariable("id") long id) {
        ShipModel ship = shipRepository.findById(id).orElse(null);
        if (ship != null) {
            shipRepository.delete(ship);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.seabattle.services.impl;

import com.example.seabattle.models.CellModel;
import com.example.seabattle.models.ShipModel;
import com.example.seabattle.repositories.IShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShipService {
    private final IShipRepository shipRepository;

    @Autowired
    public ShipService(IShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public ShipModel createShip(String name, int size, Set<CellModel> cells, int dragCount) {
        ShipModel ship = new ShipModel( name, size, cells,dragCount);
        return shipRepository.save(ship);
    }

    public List<ShipModel> getAllShips() {
        return shipRepository.findAll();
    }

    public Optional<ShipModel> getShipById(long id) {
        return shipRepository.findById(id);
    }

    public void deleteShip(ShipModel ship) {
        shipRepository.delete(ship);
    }

    public List<ShipModel> getShipsByBoardId(long boardId) {
        return shipRepository.findByBoardId(boardId);
    }

    public boolean isShipSunk(ShipModel ship) {
        return ship.getHits() >= ship.getSize();
    }

    public void updateShipAfterSinking(ShipModel ship) {
        ship.setHits(ship.getHits() + 1);
        shipRepository.save(ship);
    }
}

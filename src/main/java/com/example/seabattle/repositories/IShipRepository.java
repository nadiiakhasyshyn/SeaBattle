package com.example.seabattle.repositories;

import com.example.seabattle.models.ShipModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShipRepository extends JpaRepository<ShipModel, Long> {

    List<ShipModel> findByBoardId(long boardId);
}

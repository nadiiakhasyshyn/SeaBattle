package com.example.seabattle.repositories;

import com.example.seabattle.models.ShipModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipRepository extends JpaRepository<ShipModel, Long> {

}

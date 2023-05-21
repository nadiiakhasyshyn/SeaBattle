package com.example.seabattle.repositories;

import com.example.seabattle.models.ShipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShipRepository extends JpaRepository<ShipModel, Long> {

}

package com.example.seabattle.repositories;

import com.example.seabattle.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository extends JpaRepository<GameModel, Long> {

}

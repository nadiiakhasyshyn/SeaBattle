package com.example.seabattle.repositories;

import com.example.seabattle.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {

}

package com.example.seabattle.repositories;

import com.example.seabattle.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<GameModel, Long> {

}

package com.example.seabattle.repositories;

import com.example.seabattle.models.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IPlayerRepository extends JpaRepository <PlayerModel, Long>  {
    PlayerModel findByName(String name);
}

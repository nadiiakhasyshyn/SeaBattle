package com.example.seabattle.repositories;

import com.example.seabattle.models.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoardRepository extends JpaRepository<BoardModel, Long> {

}

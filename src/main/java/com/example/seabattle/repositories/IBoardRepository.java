package com.example.seabattle.repositories;

import com.example.seabattle.api.models.BoardApiModel;
import com.example.seabattle.models.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBoardRepository extends JpaRepository<BoardModel, Long> {

    BoardModel findById(long id);

}

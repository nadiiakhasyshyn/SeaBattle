package com.example.seabattle.repositories;

import com.example.seabattle.models.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<BoardModel, Long> {

}

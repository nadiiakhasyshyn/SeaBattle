package com.example.seabattle.repositories;

import com.example.seabattle.models.CellModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICellRepository extends JpaRepository<CellModel, Long> {

}

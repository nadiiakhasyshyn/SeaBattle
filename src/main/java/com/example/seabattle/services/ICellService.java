package com.example.seabattle.services;

import com.example.seabattle.api.models.CellApiModel;

import java.util.List;

public interface ICellService {
    List<CellApiModel> getAll();

    CellApiModel getById(long id);

    CellApiModel create(CellApiModel entity);

    CellApiModel update(CellApiModel entity);

    CellApiModel delete(long id);
}

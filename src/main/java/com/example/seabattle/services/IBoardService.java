package com.example.seabattle.services;

import com.example.seabattle.api.models.BoardApiModel;

import java.util.List;

public interface IBoardService {
    List<BoardApiModel> getAll();

    BoardApiModel getById(long id);

    BoardApiModel create(BoardApiModel entity);

    BoardApiModel update(BoardApiModel entity);

    BoardApiModel delete(long id);
}

package com.example.seabattle.services;

import com.example.seabattle.api.models.GameApiModel;

import java.util.List;

public interface IGameService {
    List<GameApiModel> getAll();

    GameApiModel getById(long id);

    GameApiModel create(GameApiModel entity);

    GameApiModel update(GameApiModel entity);

    GameApiModel delete(long id);
}

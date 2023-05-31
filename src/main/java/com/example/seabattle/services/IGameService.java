package com.example.seabattle.services;

import com.example.seabattle.api.models.GameApiModel;
import com.example.seabattle.models.BoardModel;

import java.util.List;

public interface IGameService {

    List<GameApiModel>  getAll(GameApiModel entity);

    GameApiModel create(GameApiModel entity);

    GameApiModel delete(long id);
}

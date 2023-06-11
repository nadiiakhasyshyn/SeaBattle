package com.example.seabattle.services;

import com.example.seabattle.api.models.PlayerApiModel;

import java.util.List;

public interface IPlayerService {
    List<PlayerApiModel> getAll();

    PlayerApiModel getById(long id);

    PlayerApiModel create(PlayerApiModel entity);

    PlayerApiModel update(PlayerApiModel entity);

    PlayerApiModel delete(long id);

    PlayerApiModel updateByName(String name, PlayerApiModel entity);

    PlayerApiModel getByName(String name);


}

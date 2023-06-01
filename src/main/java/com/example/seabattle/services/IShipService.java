package com.example.seabattle.services;

import com.example.seabattle.api.models.ShipApiModel;

import java.util.List;

public interface IShipService {
    List<ShipApiModel> getAll();

    ShipApiModel getById(long id);

    ShipApiModel create(ShipApiModel entity);

    ShipApiModel update(ShipApiModel entity);

    ShipApiModel delete(long id);
}

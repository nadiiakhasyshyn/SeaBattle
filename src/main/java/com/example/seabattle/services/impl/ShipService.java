package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.ShipApiModel;
import com.example.seabattle.models.BoardModel;
import com.example.seabattle.models.ShipModel;
import com.example.seabattle.repositories.IShipRepository;
import com.example.seabattle.services.IShipService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService implements IShipService {
    private final IShipRepository _repository;

    private final Mapper _mapper;

    public ShipService(IShipRepository shipRepository) {
        super();
        this._repository = shipRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    private ShipApiModel convertToShipApiModel(ShipModel model) {
        if (model != null) {
            var newShip = _mapper.map(model, ShipApiModel.class);
            newShip.setBoardId(model.getBoard().getId());
            return newShip;
        }
        return null;
    }

    @Override
    public List<ShipApiModel> getAll() {
        List<ShipModel> ships = _repository.findAll();
        List<ShipApiModel> result = new ArrayList<>();
        for (ShipModel s : ships) {
            result.add(convertToShipApiModel(s));
        }
        return result;
    }

    @Override
    public ShipApiModel getById(long id) {
        var result = _repository.findById(id);
        return convertToShipApiModel(result.orElse(null));
    }

    @Override
    public ShipApiModel create(ShipApiModel entity) {
        ShipModel model = _mapper.map(entity, ShipModel.class);
        var newBoard = new BoardModel();
        newBoard.setId(entity.getBoardId());
        model.setBoard(newBoard);
        ShipModel result = _repository.save(model);
        return convertToShipApiModel(result);
    }

    @Override
    public ShipApiModel update(ShipApiModel entity) {
        Optional<ShipModel> existingModel = _repository.findById(entity.getId());
        ShipModel resultModel = null;
        if (existingModel.isPresent()) {
            resultModel = existingModel.get();
            resultModel.setName(entity.getName());
            resultModel.setSize(entity.getSize());
            resultModel.setHits(entity.getHits());
            resultModel.setVertical(entity.isVertical());
            resultModel.setDragCount(entity.getDragCount());
            _repository.save(resultModel);
        }
        return convertToShipApiModel(resultModel);
    }

    @Override
    public ShipApiModel delete(long id) {
        Optional<ShipModel> model = _repository.findById(id);
        if (model.isPresent()) {
            _repository.deleteById(id);
            return convertToShipApiModel(model.get());
        }
        return null;
    }


}

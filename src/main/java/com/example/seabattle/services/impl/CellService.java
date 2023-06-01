package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.CellApiModel;
import com.example.seabattle.api.models.ShipApiModel;
import com.example.seabattle.models.BoardModel;
import com.example.seabattle.models.CellModel;
import com.example.seabattle.models.ShipModel;
import com.example.seabattle.repositories.ICellRepository;
import com.example.seabattle.services.ICellService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CellService implements ICellService {

    private final ICellRepository _repository;

    private final Mapper _mapper;

    public CellService(ICellRepository cellRepository) {
        super();
        this._repository = cellRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    private CellApiModel convertToCellApiModel(CellModel model) {
        if (model != null) {
            var newCell = _mapper.map(model, CellApiModel.class);
            newCell.setShipId(model.getShip().getId());
            return newCell;
        }
        return null;
    }

    @Override
    public List<CellApiModel> getAll() {
        List<CellModel> cells = _repository.findAll();
        List<CellApiModel> result = new ArrayList<>();
        for (CellModel c : cells) {
            result.add(convertToCellApiModel(c));
        }
        return result;
    }

    @Override
    public CellApiModel getById(long id) {
        var result = _repository.findById(id);
        return convertToCellApiModel(result.orElse(null));
    }

    @Override
    public CellApiModel create(CellApiModel entity) {
        CellModel model = _mapper.map(entity, CellModel.class);
        var newShip = new ShipModel();
        newShip.setId(entity.getShipId());
        model.setShip(newShip);
        CellModel result = _repository.save(model);
        return convertToCellApiModel(result);
    }

    @Override
    public CellApiModel update(CellApiModel entity) {
        Optional<CellModel> existingModel = _repository.findById(entity.getId());
        CellModel resultModel = null;
        if (existingModel.isPresent()) {
            resultModel = existingModel.get();
            resultModel.setX(entity.getX());
            resultModel.setY(entity.getY());
            _repository.save(resultModel);
        }
        return convertToCellApiModel(resultModel);
    }

    @Override
    public CellApiModel delete(long id) {
        Optional<CellModel> model = _repository.findById(id);
        if (model.isPresent()) {
            _repository.deleteById(id);
            return convertToCellApiModel(model.get());
        }
        return null;
    }

}

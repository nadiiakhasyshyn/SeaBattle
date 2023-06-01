package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.GameApiModel;
import com.example.seabattle.models.GameModel;
import com.example.seabattle.repositories.IGameRepository;
import com.example.seabattle.services.IGameService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {
    private final IGameRepository _repository;
    private final Mapper _mapper;

    public GameService(IGameRepository repository){
        super();
        _repository = repository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    private GameApiModel convertToGameApiModel(GameModel model) {
        if (model != null) {
            return _mapper.map(model, GameApiModel.class);
        }
        return null;
    }

    public GameApiModel create(GameApiModel entity){
        GameModel model = _mapper.map(entity, GameModel.class);
        GameModel result = _repository.save(model);
        return convertToGameApiModel(result);
    }

    @Override
    public GameApiModel update(GameApiModel entity) {
        var model = _mapper.map(entity, GameModel.class);
        Optional<GameModel> existingOptionalModel = _repository.findById(entity.getId());
        if (existingOptionalModel.isPresent()) {
            GameModel existingModel = existingOptionalModel.get();
            existingModel.setName(model.getName());
            existingModel.setGameState(model.getGameState());
            _repository.save(existingModel);
            return convertToGameApiModel(existingModel);
        }
        return null;
    }

    @Override
    public List<GameApiModel> getAll() {
        List<GameModel> games = _repository.findAll();
        List<GameApiModel> result = new ArrayList<>();
        for (GameModel g : games) {
            result.add(convertToGameApiModel(g));
        }
        return result;
    }

    @Override
    public GameApiModel getById(long id) {
        Optional<GameModel> result = _repository.findById(id);
        return convertToGameApiModel(result.orElse(null));
    }


    @Override
    public GameApiModel delete(long id) {
        Optional<GameModel> model = _repository.findById(id);
        if (model.isPresent()) {
            _repository.deleteById(id);
            return convertToGameApiModel(model.get());
        }
        return null;
    }
}


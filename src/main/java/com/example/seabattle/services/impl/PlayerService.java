package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.PlayerApiModel;
import com.example.seabattle.models.PlayerModel;
import com.example.seabattle.repositories.IPlayerRepository;
import com.example.seabattle.services.IPlayerService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    private final IPlayerRepository _repository;

    private final Mapper _mapper;

    public PlayerService(IPlayerRepository playerRepository) {
        super();
        this._repository = playerRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    private PlayerApiModel convertToPlayerApiModel(PlayerModel model) {
        if (model != null) {
            return _mapper.map(model, PlayerApiModel.class);
        }
        return null;
    }

    @Override
    public List<PlayerApiModel> getAll() {
        List<PlayerModel> players = _repository.findAll();
        List<PlayerApiModel> result = new ArrayList<>();
        for (PlayerModel player : players) {
            result.add(convertToPlayerApiModel(player));
        }
        return result;
    }

    @Override
    public PlayerApiModel getById(long id) {
        Optional<PlayerModel> result = _repository.findById(id);
        return convertToPlayerApiModel(result.orElse(null));
    }

    @Override
    public PlayerApiModel create(PlayerApiModel entity) {
        PlayerModel model = _mapper.map(entity, PlayerModel.class);
        PlayerModel result = _repository.save(model);
        return convertToPlayerApiModel(result);
    }

    @Override
    public PlayerApiModel update(PlayerApiModel entity) {
        Optional<PlayerModel> existingModel = _repository.findById(entity.getId());
        PlayerModel resultModel = null;
        if (existingModel.isPresent()) {
            resultModel = existingModel.get();
            resultModel.setName(entity.getName());
            resultModel.setVictories(entity.getVictories());
            resultModel.setLosses(entity.getLosses());
            resultModel.setTotalGames(entity.getTotalGames());
            _repository.save(resultModel);
        }
        return convertToPlayerApiModel(resultModel);
    }

    @Override
    public PlayerApiModel delete(long id) {
        Optional<PlayerModel> model = _repository.findById(id);
        if (model.isPresent()) {
            _repository.deleteById(id);
            return convertToPlayerApiModel(model.get());
        }
        return null;
    }

    @Override
    public PlayerApiModel updateByName(String name, PlayerApiModel entity) {
        PlayerModel existingModel = _repository.findByName(name);
        PlayerModel resultModel = null;
        if (existingModel != null) {
            resultModel = existingModel;
            resultModel.setName(entity.getName());
            resultModel.setVictories(entity.getVictories());
            resultModel.setLosses(entity.getLosses());
            resultModel.setTotalGames(entity.getTotalGames());
            _repository.save(resultModel);
        }
        return convertToPlayerApiModel(resultModel);
    }

    @Override
    public PlayerApiModel getByName(String name) {
        PlayerModel player = _repository.findByName(name);
        return convertToPlayerApiModel(player);
    }
}

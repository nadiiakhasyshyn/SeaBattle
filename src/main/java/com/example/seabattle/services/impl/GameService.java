package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.GameApiModel;
import com.example.seabattle.models.GameModel;
import com.example.seabattle.repositories.IBoardRepository;
import com.example.seabattle.repositories.IGameRepository;
import com.example.seabattle.services.IGameService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {
    private final IGameRepository _repository;
    private final Mapper _mapper;
    private final IBoardRepository _boardRepository;
    public GameService(IGameRepository repository, IBoardRepository computerRepository){
        _repository = repository;
        _computerRepository = computerRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }


    private GameModel AddBoardToModel(GameApiModel entity){
        var model = _mapper.map(entity, GameModel.class);
        var computer = _computerRepository.findById(entity.getComputerId());
        if(computer.isPresent()){
            model.setComputer(computer.get());
            model.setFree(false);
            computer.get().addComponent(model);
        }
        return model;
    }


    @Override
    public List<GameApiModel> getAll(GameApiModel entity) {
        return null;
    }

    @Override
    public GameApiModel create(GameApiModel entity) {
        var model = _mapper.map(entity, GameModel.class);
        model = AddBoardToModel(entity);

        var result = _repository.save(model);
        var newModel = _mapper.map(result, GameApiModel.class);
        if(result.get() != null){
            newModel.setComputerId(result.getComputer().getId());
        }
        return newModel;
    }

    @Override
    public GameApiModel delete(long id) {
        return null;
    }
}


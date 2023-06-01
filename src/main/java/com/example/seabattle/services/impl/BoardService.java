package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.BoardApiModel;
import com.example.seabattle.models.BoardModel;
import com.example.seabattle.models.GameModel;
import com.example.seabattle.repositories.IBoardRepository;
import com.example.seabattle.services.IBoardService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.dozermapper.core.Mapper;

@Service
public class BoardService implements IBoardService {
    private final IBoardRepository _repository;

    private final Mapper _mapper;

    public BoardService(IBoardRepository boardRepository) {
        super();
        this._repository = boardRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    private BoardApiModel convertToBoardApiModel(BoardModel model) {
        if (model != null) {
            var newBoard = _mapper.map(model, BoardApiModel.class);
            newBoard.setGameId(model.getGame().getId());
            return newBoard;
        }
        return null;
    }

    @Override
    public List<BoardApiModel> getAll() {
        List<BoardModel> boards = _repository.findAll();
        List<BoardApiModel> result = new ArrayList<>();
        for (BoardModel b : boards) {
            result.add(convertToBoardApiModel(b));
        }
        return result;
    }

    @Override
    public BoardApiModel getById(long id) {
        var result = _repository.findById(id);
        return convertToBoardApiModel(result.orElse(null));
    }

    @Override
    public BoardApiModel create(BoardApiModel entity) {
        BoardModel model = _mapper.map(entity, BoardModel.class);
        var newGame = new GameModel();
        newGame.setId(entity.getGameId());
        model.setGame(newGame);
        BoardModel result = _repository.save(model);
        return convertToBoardApiModel(result);
    }

    @Override
    public BoardApiModel update(BoardApiModel entity) {
        Optional<BoardModel> existingModel = _repository.findById(entity.getId());
        BoardModel resultModel = null;
        if (existingModel.isPresent()) {
            resultModel = existingModel.get();
            resultModel.setBoardSize(entity.getBoardSize());
            _repository.save(resultModel);
        }
        return convertToBoardApiModel(resultModel);
    }

    @Override
    public BoardApiModel delete(long id) {
        Optional<BoardModel> model = _repository.findById(id);
        if (model.isPresent()) {
            _repository.deleteById(id);
            return convertToBoardApiModel(model.get());
        }
        return null;
    }
}

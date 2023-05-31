package com.example.seabattle.services.impl;

import com.example.seabattle.api.models.BoardApiModel;
import com.example.seabattle.models.BoardModel;
import com.example.seabattle.repositories.IBoardRepository;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class BoardService {
    private final IBoardRepository boardRepository;
    private final Mapper _mapper;
    @Autowired
    public BoardService(IBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
        _mapper = DozerBeanMapperBuilder.buildDefault();
    }

    public BoardApiModel createBoard(BoardApiModel board) {
        BoardModel result = _mapper.map(board, BoardModel.class);
        boardRepository.save(result);
        return _mapper.map(result, BoardApiModel.class);
    }

    public BoardApiModel GetById(long id) {
        BoardModel result = boardRepository.findById(id);
        if(result.isEmpty()) return null;
        return _mapper.map(result.get(), BoardApiModel.class);
    }


    public List<BoardModel> getAllBoards() {
        return boardRepository.findAll();
    }


    // Додаткові методи, якщо потрібно

}

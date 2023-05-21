package com.example.seabattle.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="board")
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "board_size")
    private Integer boardSize;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel game;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "board_id")
    private List<ShipModel> boardList;

    public BoardModel() {
        // Конструктор за замовчуванням
    }

    public BoardModel(int boardSize, List<ShipModel> boardList) {
        this.boardSize = boardSize;
        this.boardList = boardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public List<ShipModel> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<ShipModel> boardList) {
        this.boardList = boardList;
    }

}

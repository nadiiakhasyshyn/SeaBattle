package com.example.seabattle.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="board")
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "board_size")
    private int boardSize;

    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private GameModel game;

    @OneToMany(mappedBy="board", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShipModel> shipList;

    public BoardModel() {
        // Конструктор за замовчуванням
    }

    public BoardModel(int boardSize, Set<ShipModel> shipList) {
        this.boardSize = boardSize;
        this.shipList = shipList;
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

    public Set<ShipModel> getBoardList() {
        return shipList;
    }

    public void setBoardList(Set<ShipModel> shipList) {
        this.shipList = shipList;
    }

}

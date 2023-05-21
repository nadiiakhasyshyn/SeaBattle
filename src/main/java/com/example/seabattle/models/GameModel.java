package com.example.seabattle.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="games")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_game_with_friend")
    private Boolean isGameWithFriend;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<BoardModel> boardModels;

    @Column(name = "game_state")
    private String gameState;

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGameWithFriend() {
        return isGameWithFriend;
    }

    public void setGameWithFriend(boolean gameWithFriend) {
        isGameWithFriend = gameWithFriend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BoardModel> getBoardModels() {
        return boardModels;
    }

    public void setBoardModels(List<BoardModel> boardModels) {
        this.boardModels = boardModels;
    }

}

package com.example.seabattle.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="game")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_game_with_friend")
    private boolean isGameWithFriend;

    @OneToMany(mappedBy = "game", cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
    private Set<BoardModel> boardModels;

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

    public Set<BoardModel> getBoardModels() {
        return boardModels;
    }

    public void setBoardModels(Set<BoardModel> boardModels) {
        this.boardModels = boardModels;
    }

}

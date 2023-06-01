package com.example.seabattle.api.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardApiModel {
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long id;
    @JsonProperty("boardSize")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int boardSize;
    @JsonProperty("gameId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long gameId;

    @Override
    public String toString() {
        return "BoardApiModel{" +
                "id=" + id +
                ", boardSize=" + boardSize +
                ", gameId=" + gameId +
                '}';
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public BoardApiModel(){

    }

}

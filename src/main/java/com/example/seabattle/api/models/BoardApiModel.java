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

    public BoardApiModel(){

    }

}

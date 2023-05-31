package com.example.seabattle.api.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CellApiModel {
    @JsonProperty("x")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int x;
    @JsonProperty("y")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int y;

    @JsonProperty("shipId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long shipId;
    public CellApiModel(){

    }
}

package com.example.seabattle.api.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CellApiModel {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }
}

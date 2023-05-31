package com.example.seabattle.models;

import jakarta.persistence.*;

@Entity
@Table(name="cells")
public class CellModel {

    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;

    @ManyToOne
    @Id
    @JoinColumn(name = "ship_id", nullable=false)
    private ShipModel ship;


    public CellModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CellModel() {

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

    public ShipModel getShip() {
        return ship;
    }

    public void setShip(ShipModel ship) {
        this.ship = ship;
    }

}



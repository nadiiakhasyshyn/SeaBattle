package com.example.seabattle.models;

import jakarta.persistence.*;

@Entity
@Table(name="cells")
public class CellModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id", referencedColumnName = "id", nullable = false)
    private ShipModel ship;


    public CellModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CellModel() {

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

    public ShipModel getShip() {
        return ship;
    }

    public void setShip(ShipModel ship) {
        this.ship = ship;
    }
}



package com.example.seabattle.models;

import jakarta.persistence.*;


@Entity
@Table(name="ship")
public class ShipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @Column(name = "hits")
    private int hits;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable=false)
    private BoardModel board;

    public ShipModel(String name, int size) {
        this.name = name;
        this.size = size;
        this.hits = 0;
    }

    public ShipModel() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public BoardModel getBoard() {
        return board;
    }

    public void setBoard(BoardModel board) {
        this.board = board;
    }

    // Метод, який перевіряє, чи затоплений корабель
    public boolean isSunk() {
        return hits >= size;
    }
}
